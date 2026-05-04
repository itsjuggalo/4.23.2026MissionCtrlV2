package wd;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class w implements TypeVariable, Type {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f23927a;

    public w(r typeParameter) {
        kotlin.jvm.internal.t.f(typeParameter, "typeParameter");
        this.f23927a = typeParameter;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) obj;
        return kotlin.jvm.internal.t.b(getName(), typeVariable.getName()) && kotlin.jvm.internal.t.b(getGenericDeclaration(), typeVariable.getGenericDeclaration());
    }

    @Override // java.lang.reflect.TypeVariable
    public Type[] getBounds() {
        List upperBounds = this.f23927a.getUpperBounds();
        ArrayList arrayList = new ArrayList(dd.s.u(upperBounds, 10));
        Iterator it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(x.c((q) it.next(), true));
        }
        return (Type[]) arrayList.toArray(new Type[0]);
    }

    @Override // java.lang.reflect.TypeVariable
    public GenericDeclaration getGenericDeclaration() {
        throw new cd.p("An operation is not implemented: " + ("getGenericDeclaration() is not yet supported for type variables created from KType: " + this.f23927a));
    }

    @Override // java.lang.reflect.TypeVariable
    public String getName() {
        return this.f23927a.getName();
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        return getName();
    }

    public int hashCode() {
        return getName().hashCode() ^ getGenericDeclaration().hashCode();
    }

    public String toString() {
        return getTypeName();
    }
}
