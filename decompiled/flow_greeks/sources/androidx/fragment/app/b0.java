package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b0 implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f2043a;

    public b0(i0 i0Var) {
        this.f2043a = i0Var;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        o0 o0VarW;
        if (x.class.getName().equals(str)) {
            return new x(context, attributeSet, this.f2043a);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u1.c.f22145a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(u1.c.f22146b);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(u1.c.f22147c, -1);
        String string = typedArrayObtainStyledAttributes.getString(u1.c.f22148d);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !z.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id2 = view != null ? view.getId() : 0;
        if (id2 == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        p pVarI0 = resourceId != -1 ? this.f2043a.i0(resourceId) : null;
        if (pVarI0 == null && string != null) {
            pVarI0 = this.f2043a.j0(string);
        }
        if (pVarI0 == null && id2 != -1) {
            pVarI0 = this.f2043a.i0(id2);
        }
        if (pVarI0 == null) {
            pVarI0 = this.f2043a.u0().a(context.getClassLoader(), attributeValue);
            pVarI0.mFromLayout = true;
            pVarI0.mFragmentId = resourceId != 0 ? resourceId : id2;
            pVarI0.mContainerId = id2;
            pVarI0.mTag = string;
            pVarI0.mInLayout = true;
            i0 i0Var = this.f2043a;
            pVarI0.mFragmentManager = i0Var;
            pVarI0.mHost = i0Var.w0();
            pVarI0.onInflate(this.f2043a.w0().f(), attributeSet, pVarI0.mSavedFragmentState);
            o0VarW = this.f2043a.i(pVarI0);
            if (i0.J0(2)) {
                Log.v("FragmentManager", "Fragment " + pVarI0 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            if (pVarI0.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id2) + " with another fragment for " + attributeValue);
            }
            pVarI0.mInLayout = true;
            i0 i0Var2 = this.f2043a;
            pVarI0.mFragmentManager = i0Var2;
            pVarI0.mHost = i0Var2.w0();
            pVarI0.onInflate(this.f2043a.w0().f(), attributeSet, pVarI0.mSavedFragmentState);
            o0VarW = this.f2043a.w(pVarI0);
            if (i0.J0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + pVarI0 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        ViewGroup viewGroup = (ViewGroup) view;
        v1.c.g(pVarI0, viewGroup);
        pVarI0.mContainer = viewGroup;
        o0VarW.m();
        o0VarW.j();
        View view2 = pVarI0.mView;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (pVarI0.mView.getTag() == null) {
            pVarI0.mView.setTag(string);
        }
        pVarI0.mView.addOnAttachStateChangeListener(new a(o0VarW));
        return pVarI0.mView;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o0 f2044a;

        public a(o0 o0Var) {
            this.f2044a = o0Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            p pVarK = this.f2044a.k();
            this.f2044a.m();
            y0.u((ViewGroup) pVarK.mView.getParent(), b0.this.f2043a).q();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
