package com.amazon.a.a.o.c.a;

import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class f extends ObjectInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a> f14128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<a> f14129b;

    public f(InputStream inputStream) {
        super(inputStream);
        this.f14128a = new ArrayList();
        this.f14129b = new ArrayList();
    }

    public f a(a aVar) {
        this.f14128a.add(aVar);
        return this;
    }

    public f b(a aVar) {
        this.f14129b.add(aVar);
        return this;
    }

    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws InvalidClassException {
        b(objectStreamClass.getName());
        return super.resolveClass(objectStreamClass);
    }

    public f a(Pattern pattern) {
        this.f14128a.add(new e(pattern));
        return this;
    }

    public f b(Pattern pattern) {
        this.f14129b.add(new e(pattern));
        return this;
    }

    public f a(Class<?>... clsArr) {
        for (Class<?> cls : clsArr) {
            this.f14128a.add(new c(cls.getName()));
        }
        return this;
    }

    public f b(Class<?>... clsArr) {
        for (Class<?> cls : clsArr) {
            this.f14129b.add(new c(cls.getName()));
        }
        return this;
    }

    public f a(String... strArr) {
        for (String str : strArr) {
            this.f14128a.add(new g(str));
        }
        return this;
    }

    public f b(String... strArr) {
        for (String str : strArr) {
            this.f14129b.add(new g(str));
        }
        return this;
    }

    private void b(String str) throws InvalidClassException {
        Iterator<a> it = this.f14129b.iterator();
        while (it.hasNext()) {
            if (it.next().a(str)) {
                a(str);
            }
        }
        Iterator<a> it2 = this.f14128a.iterator();
        while (it2.hasNext()) {
            if (it2.next().a(str)) {
                return;
            }
        }
        a(str);
    }

    public void a(String str) throws InvalidClassException {
        throw new InvalidClassException("Class name not accepted: " + str);
    }
}
