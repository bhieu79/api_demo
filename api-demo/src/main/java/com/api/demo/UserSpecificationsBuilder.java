package com.api.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;

public class UserSpecificationsBuilder {

    private final List<Criteria> params;

    public UserSpecificationsBuilder() {
        params = new ArrayList<Criteria>();
    }

    public UserSpecificationsBuilder with(String key, Operation operation, Object value) {
        params.add(new Criteria(key, operation, value));
        return this;
    }

    public Specification<User> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification> specs = params.stream()
                .map(UserSpecification::new)
                .collect(Collectors.toList());

        Specification result = specs.get(0);

        for (int i = 1; i < params.size(); i++) {
            result = specs.get(i);
        }
        return result;
    }
}