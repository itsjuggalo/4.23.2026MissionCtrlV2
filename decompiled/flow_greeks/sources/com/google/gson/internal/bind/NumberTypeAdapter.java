package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.p;
import com.google.gson.t;
import com.google.gson.u;
import com.google.gson.v;
import gb.c;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class NumberTypeAdapter extends TypeAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f6709b = g(t.f6892b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f6710a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6712a;

        static {
            int[] iArr = new int[gb.b.values().length];
            f6712a = iArr;
            try {
                iArr[gb.b.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6712a[gb.b.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6712a[gb.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public NumberTypeAdapter(u uVar) {
        this.f6710a = uVar;
    }

    public static v f(u uVar) {
        return uVar == t.f6892b ? f6709b : g(uVar);
    }

    public static v g(u uVar) {
        return new v() { // from class: com.google.gson.internal.bind.NumberTypeAdapter.1
            @Override // com.google.gson.v
            public TypeAdapter create(Gson gson, fb.a aVar) {
                if (aVar.c() == Number.class) {
                    return NumberTypeAdapter.this;
                }
                return null;
            }
        };
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Number c(gb.a aVar) throws IOException {
        gb.b bVarN0 = aVar.n0();
        int i10 = a.f6712a[bVarN0.ordinal()];
        if (i10 == 1) {
            aVar.j0();
            return null;
        }
        if (i10 == 2 || i10 == 3) {
            return this.f6710a.a(aVar);
        }
        throw new p("Expecting number, got: " + bVarN0 + "; at path " + aVar.K());
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void e(c cVar, Number number) throws IOException {
        cVar.n0(number);
    }
}
