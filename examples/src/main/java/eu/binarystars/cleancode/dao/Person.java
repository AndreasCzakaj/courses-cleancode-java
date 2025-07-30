package eu.binarystars.cleancode.dao;

import lombok.Builder;

@Builder(toBuilder = true)
public class Person {
    final String id;
    final String userName;
    final String passwordHash;
    final String email;
}
