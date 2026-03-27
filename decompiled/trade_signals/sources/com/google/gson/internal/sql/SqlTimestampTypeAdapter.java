package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.v;
import java.sql.Timestamp;
import java.util.Date;
import o4.C2462a;
import p4.C2568a;
import p4.C2570c;

/* JADX INFO: loaded from: classes.dex */
class SqlTimestampTypeAdapter extends TypeAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f16212b = new v() { // from class: com.google.gson.internal.sql.SqlTimestampTypeAdapter.1
        @Override // com.google.gson.v
        public TypeAdapter create(Gson gson, C2462a c2462a) {
            if (c2462a.c() == Timestamp.class) {
                return new SqlTimestampTypeAdapter(gson.k(Date.class));
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeAdapter f16213a;

    public SqlTimestampTypeAdapter(TypeAdapter typeAdapter) {
        this.f16213a = typeAdapter;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Timestamp c(C2568a c2568a) {
        Date date = (Date) this.f16213a.c(c2568a);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(C2570c c2570c, Timestamp timestamp) {
        this.f16213a.e(c2570c, timestamp);
    }
}
