package com.revenuecat.purchases.utils.serializers;

import F3.b;
import H3.d;
import H3.e;
import H3.h;
import I3.f;
import K3.g;
import K3.i;
import X2.AbstractC0769p;
import X2.AbstractC0770q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class GoogleListSerializer implements b {
    public static final GoogleListSerializer INSTANCE = new GoogleListSerializer();
    private static final e descriptor = h.a("GoogleList", d.i.f742a);

    private GoogleListSerializer() {
    }

    @Override // F3.b, F3.h, F3.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // F3.a
    public List<String> deserialize(I3.e decoder) {
        r.f(decoder, "decoder");
        g gVar = decoder instanceof g ? (g) decoder : null;
        if (gVar == null) {
            throw new IllegalStateException("This serializer can be used only with JSON format");
        }
        K3.h hVar = (K3.h) i.n(gVar.k()).get("google");
        K3.b bVarM = hVar != null ? i.m(hVar) : null;
        if (bVarM == null) {
            return AbstractC0769p.g();
        }
        ArrayList arrayList = new ArrayList(AbstractC0770q.q(bVarM, 10));
        Iterator<K3.h> it = bVarM.iterator();
        while (it.hasNext()) {
            arrayList.add(i.o(it.next()).f());
        }
        return arrayList;
    }

    @Override // F3.h
    public void serialize(f encoder, List<String> value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        throw new UnsupportedOperationException("Serialization is not supported");
    }
}
