package com.google.android.gms.internal.play_billing;

import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.h1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1343h1 extends AbstractC1348i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC1378o1 f15422c;

    public C1343h1(AbstractC1378o1 abstractC1378o1) {
        Objects.requireNonNull(abstractC1378o1);
        this.f15422c = abstractC1378o1;
        this.f15420a = 0;
        this.f15421b = abstractC1378o1.e();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f15420a < this.f15421b;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1358k1
    public final byte zza() {
        int i8 = this.f15420a;
        if (i8 >= this.f15421b) {
            throw new NoSuchElementException();
        }
        this.f15420a = i8 + 1;
        return this.f15422c.d(i8);
    }
}
