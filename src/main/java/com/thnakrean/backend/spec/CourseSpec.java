package com.thnakrean.backend.spec;

import com.thnakrean.backend.entities.Course;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@Data
public class CourseSpec implements Specification<Course> {
    private final CourseFilter courseFilter;
    List<Predicate> predicates = new ArrayList<>();
    @Override
    public Predicate toPredicate(Root<Course> courseRoot, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if(courseFilter.getTitle()!=null){
            Predicate name = cb.like(cb.upper(courseRoot.get("title")), "%" + courseFilter.getTitle() + "%");
            predicates.add(name);
        }
        if(courseFilter.getId()!=null){
            Predicate id = courseRoot.get("id").in(courseFilter.getId());
            predicates.add(id);
        }
        if(courseFilter.getCategoryId()!=null){
            Predicate category = cb.equal(courseRoot.get("category").get("id"), courseFilter.getCategoryId());
            predicates.add(category);
        }
        return cb.and(predicates.toArray(Predicate[]::new));
    }
}
