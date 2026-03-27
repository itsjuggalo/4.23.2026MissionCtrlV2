package com.google.android.gms.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0430h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f5237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f5238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f5239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5240d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final P1.a f5241f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f5242g;

    public C0430h(Set set, String str, String str2) {
        P1.a aVar = P1.a.f2345a;
        Set setUnmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.f5237a = setUnmodifiableSet;
        Map map = Collections.EMPTY_MAP;
        this.f5239c = map;
        this.f5240d = str;
        this.e = str2;
        this.f5241f = aVar;
        HashSet hashSet = new HashSet(setUnmodifiableSet);
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        this.f5238b = Collections.unmodifiableSet(hashSet);
    }
}
