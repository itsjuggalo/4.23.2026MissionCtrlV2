package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import io.flutter.plugins.firebase.crashlytics.Constants;

/* JADX INFO: loaded from: classes.dex */
public class B implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f7235a;

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ O f7236a;

        public a(O o4) {
            this.f7236a = o4;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pK = this.f7236a.k();
            this.f7236a.m();
            Z.u((ViewGroup) abstractComponentCallbacksC0828pK.mView.getParent(), B.this.f7235a).q();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public B(I i4) {
        this.f7235a = i4;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        O oW;
        if (C0835x.class.getName().equals(str)) {
            return new C0835x(context, attributeSet, this.f7235a);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, Constants.CLASS);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, X.c.f5522a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(X.c.f5523b);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(X.c.f5524c, -1);
        String string = typedArrayObtainStyledAttributes.getString(X.c.f5525d);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !AbstractC0837z.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pI0 = resourceId != -1 ? this.f7235a.i0(resourceId) : null;
        if (abstractComponentCallbacksC0828pI0 == null && string != null) {
            abstractComponentCallbacksC0828pI0 = this.f7235a.j0(string);
        }
        if (abstractComponentCallbacksC0828pI0 == null && id != -1) {
            abstractComponentCallbacksC0828pI0 = this.f7235a.i0(id);
        }
        if (abstractComponentCallbacksC0828pI0 == null) {
            abstractComponentCallbacksC0828pI0 = this.f7235a.u0().a(context.getClassLoader(), attributeValue);
            abstractComponentCallbacksC0828pI0.mFromLayout = true;
            abstractComponentCallbacksC0828pI0.mFragmentId = resourceId != 0 ? resourceId : id;
            abstractComponentCallbacksC0828pI0.mContainerId = id;
            abstractComponentCallbacksC0828pI0.mTag = string;
            abstractComponentCallbacksC0828pI0.mInLayout = true;
            I i4 = this.f7235a;
            abstractComponentCallbacksC0828pI0.mFragmentManager = i4;
            abstractComponentCallbacksC0828pI0.mHost = i4.w0();
            abstractComponentCallbacksC0828pI0.onInflate(this.f7235a.w0().f(), attributeSet, abstractComponentCallbacksC0828pI0.mSavedFragmentState);
            oW = this.f7235a.i(abstractComponentCallbacksC0828pI0);
            if (I.J0(2)) {
                Log.v("FragmentManager", "Fragment " + abstractComponentCallbacksC0828pI0 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            if (abstractComponentCallbacksC0828pI0.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            abstractComponentCallbacksC0828pI0.mInLayout = true;
            I i5 = this.f7235a;
            abstractComponentCallbacksC0828pI0.mFragmentManager = i5;
            abstractComponentCallbacksC0828pI0.mHost = i5.w0();
            abstractComponentCallbacksC0828pI0.onInflate(this.f7235a.w0().f(), attributeSet, abstractComponentCallbacksC0828pI0.mSavedFragmentState);
            oW = this.f7235a.w(abstractComponentCallbacksC0828pI0);
            if (I.J0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + abstractComponentCallbacksC0828pI0 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        ViewGroup viewGroup = (ViewGroup) view;
        Y.c.g(abstractComponentCallbacksC0828pI0, viewGroup);
        abstractComponentCallbacksC0828pI0.mContainer = viewGroup;
        oW.m();
        oW.j();
        View view2 = abstractComponentCallbacksC0828pI0.mView;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (abstractComponentCallbacksC0828pI0.mView.getTag() == null) {
            abstractComponentCallbacksC0828pI0.mView.setTag(string);
        }
        abstractComponentCallbacksC0828pI0.mView.addOnAttachStateChangeListener(new a(oW));
        return abstractComponentCallbacksC0828pI0.mView;
    }
}
