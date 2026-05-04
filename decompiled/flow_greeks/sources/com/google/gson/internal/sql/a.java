package com.google.gson.internal.sql;

import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.v;
import java.sql.Date;
import java.sql.Timestamp;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f6838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DefaultDateTypeAdapter.a f6839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DefaultDateTypeAdapter.a f6840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v f6841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final v f6842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final v f6843f;

    /* JADX INFO: renamed from: com.google.gson.internal.sql.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class C0112a extends DefaultDateTypeAdapter.a {
        public C0112a(Class cls) {
            super(cls);
        }

        @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Date d(java.util.Date date) {
            return new Date(date.getTime());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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
        boolean z10;
        try {
            Class.forName("java.sql.Date");
            z10 = true;
        } catch (ClassNotFoundException unused) {
            z10 = false;
        }
        f6838a = z10;
        if (z10) {
            f6839b = new C0112a(Date.class);
            f6840c = new b(Timestamp.class);
            f6841d = SqlDateTypeAdapter.f6832b;
            f6842e = SqlTimeTypeAdapter.f6834b;
            f6843f = SqlTimestampTypeAdapter.f6836b;
            return;
        }
        f6839b = null;
        f6840c = null;
        f6841d = null;
        f6842e = null;
        f6843f = null;
    }
}
