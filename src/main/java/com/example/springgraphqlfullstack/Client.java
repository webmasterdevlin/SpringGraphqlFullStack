package com.example.springgraphqlfullstack;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.List;

public record Client(String id, String name, String email, String phone) {
    private static List<Client> clients = Arrays.asList(
            new Client("1", "Tony Stark", "ironman@gmail.com", "343-567-4333"),
            new Client("2", "Natasha Romanova", "blackwidow@gmail.com", "223-567-3322"),
            new Client("3", "Thor Odinson", "thor@gmail.com", "324-331-4333"),
            new Client("4", "Steve Rogers", "steve@gmail.com", "344-562-6787"),
            new Client("5", "Bruce Banner", "bruce@gmail.com", "321-468-8887")
    );

    public static Client getById(String id) {
        return clients.stream()
                .filter(client -> client.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static List<Client> getAll() {
        return clients;
    }
}
