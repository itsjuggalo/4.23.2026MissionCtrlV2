package com.google.gson;

import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Field f15979a;

    public a(Field field) {
        Objects.requireNonNull(field);
        this.f15979a = field;
    }

    public String toString() {
        return this.f15979a.toString();
    }
}
