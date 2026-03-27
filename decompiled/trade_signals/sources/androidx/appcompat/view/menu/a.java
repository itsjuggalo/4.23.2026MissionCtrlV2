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
    public Context f10397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f10398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f10399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LayoutInflater f10400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LayoutInflater f10401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g.a f10402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10403g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10404h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h f10405i;

    public a(Context context, int i8, int i9) {
        this.f10397a = context;
        this.f10400d = LayoutInflater.from(context);
        this.f10403g = i8;
        this.f10404h = i9;
    }

    @Override // androidx.appcompat.view.menu.g
    public void a(d dVar, boolean z7) {
        g.a aVar = this.f10402f;
        if (aVar != null) {
            aVar.a(dVar, z7);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.g
    public void b(boolean z7) {
        ViewGroup viewGroup = (ViewGroup) this.f10405i;
        if (viewGroup == null) {
            return;
        }
        d dVar = this.f10399c;
        int i8 = 0;
        if (dVar != null) {
            dVar.q();
            ArrayList arrayListA = this.f10399c.A();
            int size = arrayListA.size();
            int i9 = 0;
            for (int i10 = 0; i10 < size; i10++) {
                e eVar = (e) arrayListA.get(i10);
                if (o(i9, eVar)) {
                    View childAt = viewGroup.getChildAt(i9);
                    e itemData = childAt instanceof h.a ? ((h.a) childAt).getItemData() : null;
                    View viewN = n(eVar, childAt, viewGroup);
                    if (eVar != itemData) {
                        viewN.setPressed(false);
                        viewN.jumpDrawablesToCurrentState();
                    }
                    if (viewN != childAt) {
                        e(viewN, i9);
                    }
                    i9++;
                }
            }
            i8 = i9;
        }
        while (i8 < viewGroup.getChildCount()) {
            if (!l(viewGroup, i8)) {
                i8++;
            }
        }
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean d(d dVar, e eVar) {
        return false;
    }

    public void e(View view, int i8) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f10405i).addView(view, i8);
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean f(d dVar, e eVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.g
    public void g(g.a aVar) {
        this.f10402f = aVar;
    }

    @Override // androidx.appcompat.view.menu.g
    public void h(Context context, d dVar) {
        this.f10398b = context;
        this.f10401e = LayoutInflater.from(context);
        this.f10399c = dVar;
    }

    public abstract void i(e eVar, h.a aVar);

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
    public boolean j(j jVar) {
        g.a aVar = this.f10402f;
        d dVar = jVar;
        if (aVar == null) {
            return false;
        }
        if (jVar == null) {
            dVar = this.f10399c;
        }
        return aVar.b(dVar);
    }

    public h.a k(ViewGroup viewGroup) {
        return (h.a) this.f10400d.inflate(this.f10404h, viewGroup, false);
    }

    public boolean l(ViewGroup viewGroup, int i8) {
        viewGroup.removeViewAt(i8);
        return true;
    }

    public g.a m() {
        return this.f10402f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View n(e eVar, View view, ViewGroup viewGroup) {
        h.a aVarK = view instanceof h.a ? (h.a) view : k(viewGroup);
        i(eVar, aVarK);
        return (View) aVarK;
    }

    public abstract boolean o(int i8, e eVar);
}
