package com.revenuecat.purchases;

import kotlin.Metadata;
import p7.AbstractC2609b;
import p7.u;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/JsonTools;", "", "<init>", "()V", "Lp7/b;", "json", "Lp7/b;", "getJson", "()Lp7/b;", "getJson$annotations", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public final class JsonTools {
    public static final JsonTools INSTANCE = new JsonTools();
    private static final AbstractC2609b json = u.b(null, JsonTools$json$1.INSTANCE, 1, null);

    private JsonTools() {
    }

    public static /* synthetic */ void getJson$annotations() {
    }

    public final AbstractC2609b getJson() {
        return json;
    }
}
