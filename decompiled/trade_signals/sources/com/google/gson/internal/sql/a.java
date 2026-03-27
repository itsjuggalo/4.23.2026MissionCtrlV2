package com.google.gson.internal.sql;

import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.v;
import java.sql.Date;
import java.sql.Timestamp;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f16214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DefaultDateTypeAdapter.a f16215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DefaultDateTypeAdapter.a f16216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v f16217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final v f16218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final v f16219f;

    /* JADX INFO: renamed from: com.google.gson.internal.sql.a$a, reason: collision with other inner class name */
    public class C0262a extends DefaultDateTypeAdapter.a {
        public C0262a(Class cls) {
            super(cls);
        }

        @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Date d(java.util.Date date) {
            return new Date(date.getTime());
        }
    }

    public class b extends DefaultDateTypeAdapter.a {
        public b(Class cls) {
            super(cls);
        }

        @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Timestamp d(java.util.Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z7;
        v vVar;
        try {
            Class.forName("java.sql.Date");
            z7 = true;
        } catch (ClassNotFoundException unused) {
            z7 = false;
        }
        f16214a = z7;
        if (z7) {
            f16215b = new C0262a(Date.class);
            f16216c = new b(Timestamp.class);
            f16217d = SqlDateTypeAdapter.f16208b;
            f16218e = SqlTimeTypeAdapter.f16210b;
            vVar = SqlTimestampTypeAdapter.f16212b;
        } else {
            vVar = null;
            f16215b = null;
            f16216c = null;
            f16217d = null;
            f16218e = null;
        }
        f16219f = vVar;
    }
}
