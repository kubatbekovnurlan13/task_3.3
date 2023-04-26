package kg.kubatbekov.university_cms.service;

import kg.kubatbekov.university_cms.model.Group;
import kg.kubatbekov.university_cms.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public int groupsSubjectsSize() {
        List<Group> groups = groupRepository.findAll();
        int size = 0;

        for (Group group : groups) {
            size = size + group.getSubjects().size();
        }
        return size;
    }

    public void save(Group group) {
        groupRepository.save(group);
    }

    public Optional<Group> findById(int id) {
        return groupRepository.findById(id);
    }

    public Group update(Group group) {
        return groupRepository.save(group);
    }

    public void deleteById(int id) {
        groupRepository.deleteById(id);
    }
}
