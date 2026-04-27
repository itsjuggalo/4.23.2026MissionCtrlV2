package com.amazon.a.a.i;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import com.amazon.a.a.i.c;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f8529b = new com.amazon.a.a.o.c("SimplePrompt");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f8530e = "OK";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final c f8531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final a f8532d;

    public enum a {
        LEGACY,
        EXTENDED
    }

    public h(c cVar) {
        this(cVar, a.LEGACY);
    }

    private void a(AlertDialog.Builder builder) {
        String[] strArrB = this.f8531c.b();
        if (strArrB.length < 1 || strArrB.length > 2) {
            f8529b.b("Unexpected button count: " + strArrB.length);
            return;
        }
        boolean[] zArrA = a(this.f8531c.c());
        int i4 = -1;
        int i5 = 0;
        for (int i6 = 0; i6 < zArrA.length; i6++) {
            if (zArrA[i6]) {
                i5++;
                i4 = i6;
            }
        }
        if (i5 == 1) {
            f8529b.a("single button dialog");
            a(builder, strArrB[i4], i4);
        } else {
            f8529b.a("two button dialog");
            builder.setNegativeButton(strArrB[0], new DialogInterface.OnClickListener() { // from class: com.amazon.a.a.i.h.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i7) {
                    if (h.this.k()) {
                        h.this.a(0);
                    }
                }
            });
            builder.setPositiveButton(strArrB[1], new DialogInterface.OnClickListener() { // from class: com.amazon.a.a.i.h.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i7) {
                    if (h.this.k()) {
                        h.this.a(1);
                    }
                }
            });
        }
    }

    private final Dialog e(Activity activity) {
        f8529b.a("Legacy mode dialog, legacy title = " + this.f8531c.e() + ", extended title = " + this.f8531c.f());
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(this.f8531c.f()).setMessage(this.f8531c.d()).setCancelable(false).setNeutralButton(f8530e, new DialogInterface.OnClickListener() { // from class: com.amazon.a.a.i.h.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                if (h.this.k()) {
                    h.this.i();
                }
            }
        });
        return builder.create();
    }

    private final Dialog f(Activity activity) {
        com.amazon.a.a.o.c cVar = f8529b;
        cVar.a("doCreate() called to create extended dialog");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(this.f8531c.f()).setMessage(this.f8531c.d()).setCancelable(false);
        a(builder);
        cVar.a("doCreate() returning");
        return builder.create();
    }

    @Override // com.amazon.a.a.i.b
    public boolean b(Activity activity) {
        return this.f8531c.h();
    }

    @Override // com.amazon.a.a.i.b
    public final Dialog d(Activity activity) {
        return this.f8532d == a.LEGACY ? e(activity) : f(activity);
    }

    public abstract void i();

    public h(c cVar, a aVar) {
        com.amazon.a.a.o.a.a.a((Object) cVar, FirebaseAnalytics.Param.CONTENT);
        this.f8531c = cVar;
        this.f8532d = aVar;
        f8529b.a("created SimplePrompt with mode " + aVar);
    }

    private void a(AlertDialog.Builder builder, String str, final int i4) {
        builder.setNeutralButton(str, new DialogInterface.OnClickListener() { // from class: com.amazon.a.a.i.h.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i5) {
                if (h.this.k()) {
                    h.this.a(i4);
                }
            }
        });
    }

    private boolean[] a(c.a[] aVarArr) {
        if (aVarArr == null) {
            return null;
        }
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i4 = 0; i4 < aVarArr.length; i4++) {
            boolean zA = a(aVarArr[i4]);
            zArr[i4] = zA;
            if (!zA) {
                f8529b.a("filterActions() filtering item " + i4);
            }
        }
        return zArr;
    }

    @Override // com.amazon.a.a.i.b
    public void a(d dVar) {
        i();
    }

    public void a(int i4) {
        f8529b.b("extended doAction from base class called, this should never happen.");
        i();
    }

    public boolean a(c.a aVar) {
        return aVar == c.a.DEFAULT;
    }
}
