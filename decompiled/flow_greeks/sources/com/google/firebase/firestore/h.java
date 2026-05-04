package com.google.firebase.firestore;

import a7.p;
import android.content.Context;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import m9.i0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h implements a7.h, FirebaseFirestore.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f6186a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a7.g f6187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f6188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fa.a f6189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final fa.a f6190e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i0 f6191f;

    public h(Context context, a7.g gVar, fa.a aVar, fa.a aVar2, i0 i0Var) {
        this.f6188c = context;
        this.f6187b = gVar;
        this.f6189d = aVar;
        this.f6190e = aVar2;
        this.f6191f = i0Var;
        gVar.h(this);
    }

    @Override // a7.h
    public synchronized void a(String str, p pVar) {
        for (Map.Entry entry : new ArrayList(this.f6186a.entrySet())) {
            ((FirebaseFirestore) entry.getValue()).Q();
            n9.b.d(!this.f6186a.containsKey(entry.getKey()), "terminate() should have removed its entry from `instances` for key: %s", entry.getKey());
        }
    }

    public synchronized FirebaseFirestore b(String str) throws Throwable {
        try {
            try {
                FirebaseFirestore firebaseFirestoreK = (FirebaseFirestore) this.f6186a.get(str);
                if (firebaseFirestoreK == null) {
                    firebaseFirestoreK = FirebaseFirestore.K(this.f6188c, this.f6187b, this.f6189d, this.f6190e, str, this, this.f6191f);
                    this.f6186a.put(str, firebaseFirestoreK);
                }
                return firebaseFirestoreK;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    @Override // com.google.firebase.firestore.FirebaseFirestore.a
    public synchronized void remove(String str) {
        this.f6186a.remove(str);
    }
}
