package com.amazon.a.a.i;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import com.amazon.a.a.i.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f9714b = new com.amazon.a.a.o.c("SimplePrompt");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f9715e = "OK";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final c f9716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final a f9717d;

    public enum a {
        LEGACY,
        EXTENDED
    }

    public h(c cVar) {
        this(cVar, a.LEGACY);
    }

    private void a(AlertDialog.Builder builder) {
        String[] strArrB = this.f9716c.b();
        if (strArrB.length < 1 || strArrB.length > 2) {
            f9714b.b("Unexpected button count: " + strArrB.length);
            return;
        }
        boolean[] zArrA = a(this.f9716c.c());
        int i7 = -1;
        int i8 = 0;
        for (int i9 = 0; i9 < zArrA.length; i9++) {
            if (zArrA[i9]) {
                i8++;
                i7 = i9;
            }
        }
        if (i8 == 1) {
            f9714b.a("single button dialog");
            a(builder, strArrB[i7], i7);
        } else {
            f9714b.a("two button dialog");
            builder.setNegativeButton(strArrB[0], new DialogInterface.OnClickListener() { // from class: com.amazon.a.a.i.h.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    if (h.this.k()) {
                        h.this.a(0);
                    }
                }
            });
            builder.setPositiveButton(strArrB[1], new DialogInterface.OnClickListener() { // from class: com.amazon.a.a.i.h.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    if (h.this.k()) {
                        h.this.a(1);
                    }
                }
            });
        }
    }

    private final Dialog e(Activity activity) {
        f9714b.a("Legacy mode dialog, legacy title = " + this.f9716c.e() + ", extended title = " + this.f9716c.f());
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(this.f9716c.f()).setMessage(this.f9716c.d()).setCancelable(false).setNeutralButton(f9715e, new DialogInterface.OnClickListener() { // from class: com.amazon.a.a.i.h.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i7) {
                if (h.this.k()) {
                    h.this.i();
                }
            }
        });
        return builder.create();
    }

    private final Dialog f(Activity activity) {
        com.amazon.a.a.o.c cVar = f9714b;
        cVar.a("doCreate() called to create extended dialog");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(this.f9716c.f()).setMessage(this.f9716c.d()).setCancelable(false);
        a(builder);
        cVar.a("doCreate() returning");
        return builder.create();
    }

    @Override // com.amazon.a.a.i.b
    public boolean b(Activity activity) {
        return this.f9716c.h();
    }

    @Override // com.amazon.a.a.i.b
    public final Dialog d(Activity activity) {
        return this.f9717d == a.LEGACY ? e(activity) : f(activity);
    }

    public abstract void i();

    public h(c cVar, a aVar) {
        com.amazon.a.a.o.a.a.a((Object) cVar, "content");
        this.f9716c = cVar;
        this.f9717d = aVar;
        f9714b.a("created SimplePrompt with mode " + aVar);
    }

    private void a(AlertDialog.Builder builder, String str, final int i7) {
        builder.setNeutralButton(str, new DialogInterface.OnClickListener() { // from class: com.amazon.a.a.i.h.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i8) {
                if (h.this.k()) {
                    h.this.a(i7);
                }
            }
        });
    }

    private boolean[] a(c.a[] aVarArr) {
        if (aVarArr == null) {
            return null;
        }
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i7 = 0; i7 < aVarArr.length; i7++) {
            boolean zA = a(aVarArr[i7]);
            zArr[i7] = zA;
            if (!zA) {
                f9714b.a("filterActions() filtering item " + i7);
            }
        }
        return zArr;
    }

    @Override // com.amazon.a.a.i.b
    public void a(d dVar) {
        i();
    }

    public void a(int i7) {
        f9714b.b("extended doAction from base class called, this should never happen.");
        i();
    }

    public boolean a(c.a aVar) {
        return aVar == c.a.DEFAULT;
    }
}
