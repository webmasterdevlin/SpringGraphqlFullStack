package com.example.springgraphqlfullstack;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.List;

public record Project(String id, String clientId, String name, String description, String status) {
    private static List<Project> projects = Arrays.asList(
            new Project("1", "1", "eCommerce Website", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu.", "pending"),
            new Project("2", "2", "Dating App", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu.", "pending"),
            new Project("3", "3", "SEO Project", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu.", "pending"),
            new Project("4", "4", "Design Prototype", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu.", "completed"),
            new Project("5", "5", "Auction Website", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu.", "ongoing")
    );

    public static Project getById(String id) {
        return projects.stream()
                .filter(project -> project.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static List<Project> getAll() {
        return projects;
    }
}
