package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Function;
import com.google.protobuf.AbstractC1062i;

/* JADX INFO: loaded from: classes.dex */
public class SQLiteGlobalsCache implements GlobalsCache {
    private static final String SESSION_TOKEN = "sessionToken";
    private final SQLitePersistence db;

    public SQLiteGlobalsCache(SQLitePersistence sQLitePersistence) {
        this.db = sQLitePersistence;
    }

    private byte[] get(String str) {
        return (byte[]) this.db.query("SELECT value FROM globals WHERE name = ?").binding(str).firstValue(new Function() { // from class: com.google.firebase.firestore.local.O
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                return ((Cursor) obj).getBlob(0);
            }
        });
    }

    private void set(String str, byte[] bArr) {
        this.db.execute("INSERT OR REPLACE INTO globals (name, value) VALUES (?, ?)", str, bArr);
    }

    @Override // com.google.firebase.firestore.local.GlobalsCache
    public AbstractC1062i getSessionsToken() {
        byte[] bArr = get(SESSION_TOKEN);
        return bArr == null ? AbstractC1062i.f11025b : AbstractC1062i.p(bArr);
    }

    @Override // com.google.firebase.firestore.local.GlobalsCache
    public void setSessionToken(AbstractC1062i abstractC1062i) {
        set(SESSION_TOKEN, abstractC1062i.G());
    }
}
