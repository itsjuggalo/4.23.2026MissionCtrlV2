package com.google.gson;

import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Field f6627a;

    public a(Field field) {
        Objects.requireNonNull(field);
        this.f6627a = field;
    }

    public String toString() {
        return this.f6627a.toString();
    }
}
