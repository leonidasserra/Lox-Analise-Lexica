package br.com.lox;

import java.util.Map;

public class LoxClass implements LoxCallable {
    public final String name;
    private final Map<String, LoxFunction> methods;
    public LoxClass(String name, Map<String, LoxFunction> methods) {
        this.name = name; this.methods = methods;
    }

    @Override
    public int arity() {
        LoxFunction initializer = methods.get("init");
        if (initializer == null) return 0;
        return initializer.arity();
    }

    @Override
    public Object call(Interpreter interpreter, java.util.List<Object> arguments) {
        LoxInstance instance = new LoxInstance(this);
        LoxFunction initializer = methods.get("init");
        if (initializer != null) {
            initializer.bind(instance).call(interpreter, arguments);
        }
        return instance;
    }

    public LoxFunction findMethod(String name) {
        return methods.get(name);
    }

    @Override
    public String toString() {
        return "<class " + name + ">";
    }
}
