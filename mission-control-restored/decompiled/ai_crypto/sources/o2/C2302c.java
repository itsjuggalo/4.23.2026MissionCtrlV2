package o2;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import u.g;

/* JADX INFO: renamed from: o2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2302c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f20024a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f20025b = new g();

    public static void a(C2302c c2302c, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            c2302c.e(objectAnimator.getPropertyName(), objectAnimator.getValues());
            c2302c.f(objectAnimator.getPropertyName(), C2303d.a(objectAnimator));
        } else {
            throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }

    public static C2302c b(Context context, TypedArray typedArray, int i7) {
        int resourceId;
        if (!typedArray.hasValue(i7) || (resourceId = typedArray.getResourceId(i7, 0)) == 0) {
            return null;
        }
        return c(context, resourceId);
    }

    public static C2302c c(Context context, int i7) {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i7);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return d(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return d(arrayList);
        } catch (Exception e7) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i7), e7);
            return null;
        }
    }

    public static C2302c d(List list) {
        C2302c c2302c = new C2302c();
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            a(c2302c, (Animator) list.get(i7));
        }
        return c2302c;
    }

    public void e(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f20025b.put(str, propertyValuesHolderArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2302c) {
            return this.f20024a.equals(((C2302c) obj).f20024a);
        }
        return false;
    }

    public void f(String str, C2303d c2303d) {
        this.f20024a.put(str, c2303d);
    }

    public int hashCode() {
        return this.f20024a.hashCode();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f20024a + "}\n";
    }
}
