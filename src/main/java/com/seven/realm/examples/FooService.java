package com.seven.realm.examples;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
class FooFormatter implements Formatter {

    @Override
    public String format() {
        return "foo";
    }
}

@Component
class BarFormatter implements Formatter {

    @Override
    public String format() {
        return "bar";
    }
}

@Getter
@Component
public class FooService {
    @Autowired
    @Qualifier("barFormatter") // Auto wiring by @Qualifier
    private Formatter formatter;
}