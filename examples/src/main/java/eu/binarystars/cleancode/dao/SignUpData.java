package eu.binarystars.cleancode.dao;

import lombok.Builder;

@Builder
public class SignUpData {
    final String userName;
    final String password;
    final String email;
}