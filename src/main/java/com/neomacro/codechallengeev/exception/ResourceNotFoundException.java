package com.neomacro.codechallengeev.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
}