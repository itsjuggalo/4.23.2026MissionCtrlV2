package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.h;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LayoutInflater f985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LayoutInflater f986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g.a f987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f989h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h f990i;

    public a(Context context, int i10, int i11) {
        this.f982a = context;
        this.f985d = LayoutInflater.from(context);
        this.f988g = i10;
        this.f989h = i11;
    }

    @Override // androidx.appcompat.view.menu.g
    public void a(d dVar, boolean z10) {
        g.a aVar = this.f987f;
        if (aVar != null) {
            aVar.a(dVar, z10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.g
    public void b(boolean z10) {
        ViewGroup viewGroup = (ViewGroup) this.f990i;
        if (viewGroup == null) {
            return;
        }
        d dVar = this.f984c;
        int i10 = 0;
        if (dVar != null) {
            dVar.q();
            ArrayList arrayListA = this.f984c.A();
            int size = arrayListA.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                e eVar = (e) arrayListA.get(i12);
                if (o(i11, eVar)) {
                    View childAt = viewGroup.getChildAt(i11);
                    e itemData = childAt instanceof h.a ? ((h.a) childAt).getItemData() : null;
                    View viewN = n(eVar, childAt, viewGroup);
                    if (eVar != itemData) {
                        viewN.setPressed(false);
                        viewN.jumpDrawablesToCurrentState();
                    }
                    if (viewN != childAt) {
                        e(viewN, i11);
                    }
                    i11++;
                }
            }
            i10 = i11;
        }
        while (i10 < viewGroup.getChildCount()) {
            if (!l(viewGroup, i10)) {
                i10++;
            }
        }
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean d(d dVar, e eVar) {
        return false;
    }

    public void e(View view, int i10) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f990i).addView(view, i10);
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean f(d dVar, e eVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.g
    public void g(g.a aVar) {
        this.f987f = aVar;
    }

    @Override // androidx.appcompat.view.menu.g
    public void h(Context context, d dVar) {
        this.f983b = context;
        this.f986e = LayoutInflater.from(context);
        this.f984c = dVar;
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
        g.a aVar = this.f987f;
        d dVar = jVar;
        if (aVar == null) {
            return false;
        }
        if (jVar == null) {
            dVar = this.f984c;
        }
        return aVar.b(dVar);
    }

    public h.a k(ViewGroup viewGroup) {
        return (h.a) this.f985d.inflate(this.f989h, viewGroup, false);
    }

    public boolean l(ViewGroup viewGroup, int i10) {
        viewGroup.removeViewAt(i10);
        return true;
    }

    public g.a m() {
        return this.f987f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View n(e eVar, View view, ViewGroup viewGroup) {
        h.a aVarK = view instanceof h.a ? (h.a) view : k(viewGroup);
        i(eVar, aVarK);
        return (View) aVarK;
    }

    public abstract boolean o(int i10, e eVar);
}
