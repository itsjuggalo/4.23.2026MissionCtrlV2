package I5;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2488p;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements TypeVariable, Type {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f4316a;

    public w(r typeParameter) {
        AbstractC2304t.f(typeParameter, "typeParameter");
        this.f4316a = typeParameter;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) obj;
            if (AbstractC2304t.b(getName(), typeVariable.getName()) && AbstractC2304t.b(getGenericDeclaration(), typeVariable.getGenericDeclaration())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.TypeVariable
    public Type[] getBounds() {
        List upperBounds = this.f4316a.getUpperBounds();
        ArrayList arrayList = new ArrayList(p5.r.s(upperBounds, 10));
        Iterator it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(x.c((q) it.next(), true));
        }
        return (Type[]) arrayList.toArray(new Type[0]);
    }

    @Override // java.lang.reflect.TypeVariable
    public GenericDeclaration getGenericDeclaration() {
        throw new C2488p("An operation is not implemented: " + ("getGenericDeclaration() is not yet supported for type variables created from KType: " + this.f4316a));
    }

    @Override // java.lang.reflect.TypeVariable
    public String getName() {
        return this.f4316a.getName();
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
