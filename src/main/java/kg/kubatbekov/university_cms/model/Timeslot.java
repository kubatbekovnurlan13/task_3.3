package kg.kubatbekov.university_cms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Entity
@Table(name = "timeslots")
@Getter
@Setter
public class Timeslot {
    @Id
    @Column(name = "timeslot_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int timeslotId;

    @Enumerated(EnumType.STRING)
    @Column(name = "weekday")
    private Weekday weekday;

    @Basic
    @Column(name = "duration")
    private String durationValue;

    @OneToMany(mappedBy = "timeslot")
    private List<Lesson> cours;

    @Transient
    private Duration duration;

    public Timeslot() {
    }

    public Timeslot(int timeslotId, Weekday weekday, String durationValue) {
        this.timeslotId = timeslotId;
        this.weekday = weekday;
        this.durationValue = durationValue;
    }

    public static Weekday[] getWeekDays() {
        return Weekday.values();
    }

    public static List<String> getDurationAsList() {
        List<String> durationValues = new ArrayList<>();
        Stream.of(Duration.values())
                .forEach(d -> durationValues.add(d.hours));
        return durationValues;
    }

    public static Duration[] getDuration() {
        return Duration.values();
    }

    @Override
    public String toString() {
        return "Slot:" +
                "timeslotId=" + timeslotId +
                ", day=" + weekday +
                ", period=" + duration.hours;
    }

    @PostLoad
    public void fillTransient() {
        if (!durationValue.isEmpty()) {
            this.duration = Duration.of(durationValue);
        }
    }

    @PrePersist
    public void fillPersistent() {
        if (duration != null) {
            this.durationValue = duration.getHours();
        }
    }

    public enum Weekday {
        monday, tuesday, wednesday, thursday, friday
    }

    public enum Duration {
        first_period("9:00-10:30"),
        second_period("11:00-12:30"),
        third_period("13:30-15:00"),
        fourth_period("15:30-17:00"),
        fifth_period("17:30-19:00");

        private final String hours;

        Duration(String hours) {
            this.hours = hours;
        }

        public String getHours() {
            return hours;
        }

        public static Duration of(String duration) {
            return Stream.of(Duration.values())
                    .filter(d -> Objects.equals(d.hours, duration))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}
