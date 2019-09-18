package com.weeroda.feedback.security;

import com.weeroda.feedback.utils.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        if (charSequence == null) { return null; }
        return HashingService.encodeValue(charSequence.toString());
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        if (charSequence == null && s == null) { return true; }
        if (charSequence == null) { return false; }
        if (s == null) { return false; }
        String encodeValue = HashingService.encodeValue(charSequence.toString());
        return s.equals(encodeValue);
    }
}
