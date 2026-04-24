package com.google.protobuf;

import java.util.NoSuchElementException;

/* JADX INFO: renamed from: com.google.protobuf.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0462g extends AbstractC0464h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5719a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC0472l f5721c;

    public C0462g(AbstractC0472l abstractC0472l) {
        this.f5721c = abstractC0472l;
        this.f5720b = abstractC0472l.size();
    }

    @Override // com.google.protobuf.AbstractC0464h
    public final byte a() {
        int i = this.f5719a;
        if (i >= this.f5720b) {
            throw new NoSuchElementException();
        }
        this.f5719a = i + 1;
        return this.f5721c.n(i);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5719a < this.f5720b;
    }
}
