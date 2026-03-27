package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.h;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f6504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f6505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f6506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LayoutInflater f6507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LayoutInflater f6508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g.a f6509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6510g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6511h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h f6512i;

    public a(Context context, int i7, int i8) {
        this.f6504a = context;
        this.f6507d = LayoutInflater.from(context);
        this.f6510g = i7;
        this.f6511h = i8;
    }

    public void a(View view, int i7) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f6512i).addView(view, i7);
    }

    @Override // androidx.appcompat.view.menu.g
    public void b(d dVar, boolean z7) {
        g.a aVar = this.f6509f;
        if (aVar != null) {
            aVar.b(dVar, z7);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.g
    public void c(boolean z7) {
        ViewGroup viewGroup = (ViewGroup) this.f6512i;
        if (viewGroup == null) {
            return;
        }
        d dVar = this.f6506c;
        int i7 = 0;
        if (dVar != null) {
            dVar.q();
            ArrayList arrayListA = this.f6506c.A();
            int size = arrayListA.size();
            int i8 = 0;
            for (int i9 = 0; i9 < size; i9++) {
                e eVar = (e) arrayListA.get(i9);
                if (o(i8, eVar)) {
                    View childAt = viewGroup.getChildAt(i8);
                    e itemData = childAt instanceof h.a ? ((h.a) childAt).getItemData() : null;
                    View viewN = n(eVar, childAt, viewGroup);
                    if (eVar != itemData) {
                        viewN.setPressed(false);
                        viewN.jumpDrawablesToCurrentState();
                    }
                    if (viewN != childAt) {
                        a(viewN, i8);
                    }
                    i8++;
                }
            }
            i7 = i8;
        }
        while (i7 < viewGroup.getChildCount()) {
            if (!l(viewGroup, i7)) {
                i7++;
            }
        }
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean e(d dVar, e eVar) {
        return false;
    }

    public abstract void f(e eVar, h.a aVar);

    @Override // androidx.appcompat.view.menu.g
    public boolean g(d dVar, e eVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.g
    public void h(g.a aVar) {
        this.f6509f = aVar;
    }

    @Override // androidx.appcompat.view.menu.g
    public void i(Context context, d dVar) {
        this.f6505b = context;
        this.f6508e = LayoutInflater.from(context);
        this.f6506c = dVar;
    }

    public h.a j(ViewGroup viewGroup) {
        return (h.a) this.f6507d.inflate(this.f6511h, viewGroup, false);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.appcompat.view.menu.g
    public boolean k(j jVar) {
        g.a aVar = this.f6509f;
        d dVar = jVar;
        if (aVar == null) {
            return false;
        }
        if (jVar == null) {
            dVar = this.f6506c;
        }
        return aVar.c(dVar);
    }

    public boolean l(ViewGroup viewGroup, int i7) {
        viewGroup.removeViewAt(i7);
        return true;
    }

    public g.a m() {
        return this.f6509f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View n(e eVar, View view, ViewGroup viewGroup) {
        h.a aVarJ = view instanceof h.a ? (h.a) view : j(viewGroup);
        f(eVar, aVarJ);
        return (View) aVarJ;
    }

    public abstract boolean o(int i7, e eVar);
}
