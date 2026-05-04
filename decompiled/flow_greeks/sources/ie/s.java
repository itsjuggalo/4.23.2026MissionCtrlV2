package ie;

import com.google.firebase.analytics.FirebaseAnalytics;
import fe.a;
import fe.b;
import fe.b1;
import fe.g1;
import fe.l1;
import fe.s1;
import fe.z;
import ie.u0;
import io.flutter.Build;
import io.flutter.plugins.firebase.analytics.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import xf.d2;
import xf.f2;
import xf.m2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s extends n implements fe.z {
    public final fe.z A;
    public final b.a B;
    public fe.z C;
    public Map D;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f12432e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f12433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public xf.r0 f12434g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f12435h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b1 f12436i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b1 f12437j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public fe.e0 f12438k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public fe.u f12439l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f12440m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f12441n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f12442o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f12443p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f12444q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f12445r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f12446s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f12447t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f12448u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f12449v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f12450w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f12451x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Collection f12452y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile Function0 f12453z;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f2 f12454a;

        public a(f2 f2Var) {
            this.f12454a = f2Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection invoke() {
            hg.k kVar = new hg.k();
            Iterator it = s.this.f().iterator();
            while (it.hasNext()) {
                kVar.add(((fe.z) it.next()).c(this.f12454a));
            }
            return kVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f12456a;

        public b(List list) {
            this.f12456a = list;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List invoke() {
            return this.f12456a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements z.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d2 f12457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public fe.m f12458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public fe.e0 f12459c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public fe.u f12460d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public fe.z f12461e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public b.a f12462f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List f12463g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List f12464h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public b1 f12465i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public b1 f12466j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public xf.r0 f12467k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public ef.f f12468l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f12469m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f12470n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f12471o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f12472p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f12473q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public List f12474r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public ge.h f12475s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f12476t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public Map f12477u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public Boolean f12478v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f12479w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final /* synthetic */ s f12480x;

        public c(s sVar, d2 d2Var, fe.m mVar, fe.e0 e0Var, fe.u uVar, b.a aVar, List list, List list2, b1 b1Var, xf.r0 r0Var, ef.f fVar) {
            if (d2Var == null) {
                u(0);
            }
            if (mVar == null) {
                u(1);
            }
            if (e0Var == null) {
                u(2);
            }
            if (uVar == null) {
                u(3);
            }
            if (aVar == null) {
                u(4);
            }
            if (list == null) {
                u(5);
            }
            if (list2 == null) {
                u(6);
            }
            if (r0Var == null) {
                u(7);
            }
            this.f12480x = sVar;
            this.f12461e = null;
            this.f12466j = sVar.f12437j;
            this.f12469m = true;
            this.f12470n = false;
            this.f12471o = false;
            this.f12472p = false;
            this.f12473q = sVar.v0();
            this.f12474r = null;
            this.f12475s = null;
            this.f12476t = sVar.C0();
            this.f12477u = new LinkedHashMap();
            this.f12478v = null;
            this.f12479w = false;
            this.f12457a = d2Var;
            this.f12458b = mVar;
            this.f12459c = e0Var;
            this.f12460d = uVar;
            this.f12462f = aVar;
            this.f12463g = list;
            this.f12464h = list2;
            this.f12465i = b1Var;
            this.f12467k = r0Var;
            this.f12468l = fVar;
        }

        public static /* synthetic */ void u(int i10) {
            String str;
            int i11;
            switch (i10) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                case 20:
                case Build.API_LEVELS.API_22 /* 22 */:
                case 24:
                case Build.API_LEVELS.API_26 /* 26 */:
                case Build.API_LEVELS.API_27 /* 27 */:
                case Build.API_LEVELS.API_28 /* 28 */:
                case Build.API_LEVELS.API_29 /* 29 */:
                case Build.API_LEVELS.API_30 /* 30 */:
                case Build.API_LEVELS.API_31 /* 31 */:
                case 32:
                case Build.API_LEVELS.API_33 /* 33 */:
                case Build.API_LEVELS.API_34 /* 34 */:
                case Build.API_LEVELS.API_36 /* 36 */:
                case 38:
                case 40:
                case 41:
                case 42:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 10:
                case 12:
                case 14:
                case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                case 19:
                case Build.API_LEVELS.API_21 /* 21 */:
                case Build.API_LEVELS.API_23 /* 23 */:
                case Build.API_LEVELS.API_25 /* 25 */:
                case Build.API_LEVELS.API_35 /* 35 */:
                case 37:
                case 39:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i10) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                case 20:
                case Build.API_LEVELS.API_22 /* 22 */:
                case 24:
                case Build.API_LEVELS.API_26 /* 26 */:
                case Build.API_LEVELS.API_27 /* 27 */:
                case Build.API_LEVELS.API_28 /* 28 */:
                case Build.API_LEVELS.API_29 /* 29 */:
                case Build.API_LEVELS.API_30 /* 30 */:
                case Build.API_LEVELS.API_31 /* 31 */:
                case 32:
                case Build.API_LEVELS.API_33 /* 33 */:
                case Build.API_LEVELS.API_34 /* 34 */:
                case Build.API_LEVELS.API_36 /* 36 */:
                case 38:
                case 40:
                case 41:
                case 42:
                    i11 = 2;
                    break;
                case 10:
                case 12:
                case 14:
                case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                case 19:
                case Build.API_LEVELS.API_21 /* 21 */:
                case Build.API_LEVELS.API_23 /* 23 */:
                case Build.API_LEVELS.API_25 /* 25 */:
                case Build.API_LEVELS.API_35 /* 35 */:
                case 37:
                case 39:
                default:
                    i11 = 3;
                    break;
            }
            Object[] objArr = new Object[i11];
            switch (i10) {
                case 1:
                    objArr[0] = "newOwner";
                    break;
                case 2:
                    objArr[0] = "newModality";
                    break;
                case 3:
                    objArr[0] = "newVisibility";
                    break;
                case 4:
                case 14:
                    objArr[0] = "kind";
                    break;
                case 5:
                    objArr[0] = "newValueParameterDescriptors";
                    break;
                case 6:
                    objArr[0] = "newContextReceiverParameters";
                    break;
                case 7:
                    objArr[0] = "newReturnType";
                    break;
                case 8:
                    objArr[0] = "owner";
                    break;
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                case 20:
                case Build.API_LEVELS.API_22 /* 22 */:
                case 24:
                case Build.API_LEVELS.API_26 /* 26 */:
                case Build.API_LEVELS.API_27 /* 27 */:
                case Build.API_LEVELS.API_28 /* 28 */:
                case Build.API_LEVELS.API_29 /* 29 */:
                case Build.API_LEVELS.API_30 /* 30 */:
                case Build.API_LEVELS.API_31 /* 31 */:
                case 32:
                case Build.API_LEVELS.API_33 /* 33 */:
                case Build.API_LEVELS.API_34 /* 34 */:
                case Build.API_LEVELS.API_36 /* 36 */:
                case 38:
                case 40:
                case 41:
                case 42:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 10:
                    objArr[0] = "modality";
                    break;
                case 12:
                    objArr[0] = "visibility";
                    break;
                case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    objArr[0] = "name";
                    break;
                case 19:
                case Build.API_LEVELS.API_21 /* 21 */:
                    objArr[0] = Constants.PARAMETERS;
                    break;
                case Build.API_LEVELS.API_23 /* 23 */:
                    objArr[0] = "type";
                    break;
                case Build.API_LEVELS.API_25 /* 25 */:
                    objArr[0] = "contextReceiverParameters";
                    break;
                case Build.API_LEVELS.API_35 /* 35 */:
                    objArr[0] = "additionalAnnotations";
                    break;
                case 37:
                default:
                    objArr[0] = "substitution";
                    break;
                case 39:
                    objArr[0] = "userDataKey";
                    break;
            }
            switch (i10) {
                case 9:
                    objArr[1] = "setOwner";
                    break;
                case 10:
                case 12:
                case 14:
                case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                case 19:
                case Build.API_LEVELS.API_21 /* 21 */:
                case Build.API_LEVELS.API_23 /* 23 */:
                case Build.API_LEVELS.API_25 /* 25 */:
                case Build.API_LEVELS.API_35 /* 35 */:
                case 37:
                case 39:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 11:
                    objArr[1] = "setModality";
                    break;
                case 13:
                    objArr[1] = "setVisibility";
                    break;
                case 15:
                    objArr[1] = "setKind";
                    break;
                case 16:
                    objArr[1] = "setCopyOverrides";
                    break;
                case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                    objArr[1] = "setName";
                    break;
                case 20:
                    objArr[1] = "setValueParameters";
                    break;
                case Build.API_LEVELS.API_22 /* 22 */:
                    objArr[1] = "setTypeParameters";
                    break;
                case 24:
                    objArr[1] = "setReturnType";
                    break;
                case Build.API_LEVELS.API_26 /* 26 */:
                    objArr[1] = "setContextReceiverParameters";
                    break;
                case Build.API_LEVELS.API_27 /* 27 */:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case Build.API_LEVELS.API_28 /* 28 */:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case Build.API_LEVELS.API_29 /* 29 */:
                    objArr[1] = "setOriginal";
                    break;
                case Build.API_LEVELS.API_30 /* 30 */:
                    objArr[1] = "setSignatureChange";
                    break;
                case Build.API_LEVELS.API_31 /* 31 */:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 32:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case Build.API_LEVELS.API_33 /* 33 */:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case Build.API_LEVELS.API_34 /* 34 */:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case Build.API_LEVELS.API_36 /* 36 */:
                    objArr[1] = "setAdditionalAnnotations";
                    break;
                case 38:
                    objArr[1] = "setSubstitution";
                    break;
                case 40:
                    objArr[1] = "putUserData";
                    break;
                case 41:
                    objArr[1] = "getSubstitution";
                    break;
                case 42:
                    objArr[1] = "setJustForTypeSubstitution";
                    break;
            }
            switch (i10) {
                case 8:
                    objArr[2] = "setOwner";
                    break;
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                case 20:
                case Build.API_LEVELS.API_22 /* 22 */:
                case 24:
                case Build.API_LEVELS.API_26 /* 26 */:
                case Build.API_LEVELS.API_27 /* 27 */:
                case Build.API_LEVELS.API_28 /* 28 */:
                case Build.API_LEVELS.API_29 /* 29 */:
                case Build.API_LEVELS.API_30 /* 30 */:
                case Build.API_LEVELS.API_31 /* 31 */:
                case 32:
                case Build.API_LEVELS.API_33 /* 33 */:
                case Build.API_LEVELS.API_34 /* 34 */:
                case Build.API_LEVELS.API_36 /* 36 */:
                case 38:
                case 40:
                case 41:
                case 42:
                    break;
                case 10:
                    objArr[2] = "setModality";
                    break;
                case 12:
                    objArr[2] = "setVisibility";
                    break;
                case 14:
                    objArr[2] = "setKind";
                    break;
                case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    objArr[2] = "setName";
                    break;
                case 19:
                    objArr[2] = "setValueParameters";
                    break;
                case Build.API_LEVELS.API_21 /* 21 */:
                    objArr[2] = "setTypeParameters";
                    break;
                case Build.API_LEVELS.API_23 /* 23 */:
                    objArr[2] = "setReturnType";
                    break;
                case Build.API_LEVELS.API_25 /* 25 */:
                    objArr[2] = "setContextReceiverParameters";
                    break;
                case Build.API_LEVELS.API_35 /* 35 */:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                case 37:
                    objArr[2] = "setSubstitution";
                    break;
                case 39:
                    objArr[2] = "putUserData";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            switch (i10) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                case 20:
                case Build.API_LEVELS.API_22 /* 22 */:
                case 24:
                case Build.API_LEVELS.API_26 /* 26 */:
                case Build.API_LEVELS.API_27 /* 27 */:
                case Build.API_LEVELS.API_28 /* 28 */:
                case Build.API_LEVELS.API_29 /* 29 */:
                case Build.API_LEVELS.API_30 /* 30 */:
                case Build.API_LEVELS.API_31 /* 31 */:
                case 32:
                case Build.API_LEVELS.API_33 /* 33 */:
                case Build.API_LEVELS.API_34 /* 34 */:
                case Build.API_LEVELS.API_36 /* 36 */:
                case 38:
                case 40:
                case 41:
                case 42:
                    throw new IllegalStateException(str2);
                case 10:
                case 12:
                case 14:
                case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                case 19:
                case Build.API_LEVELS.API_21 /* 21 */:
                case Build.API_LEVELS.API_23 /* 23 */:
                case Build.API_LEVELS.API_25 /* 25 */:
                case Build.API_LEVELS.API_35 /* 35 */:
                case 37:
                case 39:
                default:
                    throw new IllegalArgumentException(str2);
            }
        }

        @Override // fe.z.a
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public c n(ge.h hVar) {
            if (hVar == null) {
                u(35);
            }
            this.f12475s = hVar;
            return this;
        }

        @Override // fe.z.a
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public c i(boolean z10) {
            this.f12469m = z10;
            return this;
        }

        @Override // fe.z.a
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public c f(b1 b1Var) {
            this.f12466j = b1Var;
            return this;
        }

        @Override // fe.z.a
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public c a() {
            this.f12472p = true;
            return this;
        }

        @Override // fe.z.a
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public c c(b1 b1Var) {
            this.f12465i = b1Var;
            return this;
        }

        public c G(boolean z10) {
            this.f12478v = Boolean.valueOf(z10);
            return this;
        }

        @Override // fe.z.a
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public c h() {
            this.f12476t = true;
            return this;
        }

        @Override // fe.z.a
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public c o() {
            this.f12473q = true;
            return this;
        }

        public c J(boolean z10) {
            this.f12479w = z10;
            return this;
        }

        @Override // fe.z.a
        /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
        public c m(b.a aVar) {
            if (aVar == null) {
                u(14);
            }
            this.f12462f = aVar;
            return this;
        }

        @Override // fe.z.a
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public c s(fe.e0 e0Var) {
            if (e0Var == null) {
                u(10);
            }
            this.f12459c = e0Var;
            return this;
        }

        @Override // fe.z.a
        /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
        public c j(ef.f fVar) {
            if (fVar == null) {
                u(17);
            }
            this.f12468l = fVar;
            return this;
        }

        @Override // fe.z.a
        /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
        public c r(fe.b bVar) {
            this.f12461e = (fe.z) bVar;
            return this;
        }

        @Override // fe.z.a
        /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
        public c p(fe.m mVar) {
            if (mVar == null) {
                u(8);
            }
            this.f12458b = mVar;
            return this;
        }

        @Override // fe.z.a
        /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
        public c e() {
            this.f12471o = true;
            return this;
        }

        @Override // fe.z.a
        /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
        public c g(xf.r0 r0Var) {
            if (r0Var == null) {
                u(23);
            }
            this.f12467k = r0Var;
            return this;
        }

        @Override // fe.z.a
        /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
        public c t() {
            this.f12470n = true;
            return this;
        }

        @Override // fe.z.a
        /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
        public c k(d2 d2Var) {
            if (d2Var == null) {
                u(37);
            }
            this.f12457a = d2Var;
            return this;
        }

        @Override // fe.z.a
        /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
        public c l(List list) {
            if (list == null) {
                u(21);
            }
            this.f12474r = list;
            return this;
        }

        @Override // fe.z.a
        /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
        public c b(List list) {
            if (list == null) {
                u(19);
            }
            this.f12463g = list;
            return this;
        }

        @Override // fe.z.a
        /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
        public c d(fe.u uVar) {
            if (uVar == null) {
                u(12);
            }
            this.f12460d = uVar;
            return this;
        }

        @Override // fe.z.a
        public fe.z build() {
            return this.f12480x.M0(this);
        }

        @Override // fe.z.a
        public z.a q(a.InterfaceC0175a interfaceC0175a, Object obj) {
            if (interfaceC0175a == null) {
                u(39);
            }
            this.f12477u.put(interfaceC0175a, obj);
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(fe.m mVar, fe.z zVar, ge.h hVar, ef.f fVar, b.a aVar, g1 g1Var) {
        super(mVar, hVar, fVar, g1Var);
        if (mVar == null) {
            w(0);
        }
        if (hVar == null) {
            w(1);
        }
        if (fVar == null) {
            w(2);
        }
        if (aVar == null) {
            w(3);
        }
        if (g1Var == null) {
            w(4);
        }
        this.f12439l = fe.t.f9515i;
        this.f12440m = false;
        this.f12441n = false;
        this.f12442o = false;
        this.f12443p = false;
        this.f12444q = false;
        this.f12445r = false;
        this.f12446s = false;
        this.f12447t = false;
        this.f12448u = false;
        this.f12449v = false;
        this.f12450w = true;
        this.f12451x = false;
        this.f12452y = null;
        this.f12453z = null;
        this.C = null;
        this.D = null;
        this.A = zVar == null ? this : zVar;
        this.B = aVar;
    }

    public static List O0(fe.z zVar, List list, f2 f2Var) {
        if (list == null) {
            w(28);
        }
        if (f2Var == null) {
            w(29);
        }
        return P0(zVar, list, f2Var, false, false, null);
    }

    public static List P0(fe.z zVar, List list, f2 f2Var, boolean z10, boolean z11, boolean[] zArr) {
        if (list == null) {
            w(30);
        }
        if (f2Var == null) {
            w(31);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            s1 s1Var = (s1) it.next();
            xf.r0 type = s1Var.getType();
            m2 m2Var = m2.f25016f;
            xf.r0 r0VarP = f2Var.p(type, m2Var);
            xf.r0 r0VarJ0 = s1Var.j0();
            xf.r0 r0VarP2 = r0VarJ0 == null ? null : f2Var.p(r0VarJ0, m2Var);
            if (r0VarP == null) {
                return null;
            }
            if ((r0VarP != s1Var.getType() || r0VarJ0 != r0VarP2) && zArr != null) {
                zArr[0] = true;
            }
            arrayList.add(u0.K0(zVar, z10 ? null : s1Var, s1Var.getIndex(), s1Var.getAnnotations(), s1Var.getName(), r0VarP, s1Var.s0(), s1Var.b0(), s1Var.Z(), r0VarP2, z11 ? s1Var.j() : g1.f9483a, s1Var instanceof u0.b ? new b(((u0.b) s1Var).P0()) : null));
        }
        return arrayList;
    }

    private void d1(fe.z zVar) {
        this.C = zVar;
    }

    private static /* synthetic */ void w(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
            case 20:
            case Build.API_LEVELS.API_21 /* 21 */:
            case Build.API_LEVELS.API_23 /* 23 */:
            case Build.API_LEVELS.API_26 /* 26 */:
            case Build.API_LEVELS.API_27 /* 27 */:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 10:
            case 11:
            case 12:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case Build.API_LEVELS.API_22 /* 22 */:
            case 24:
            case Build.API_LEVELS.API_25 /* 25 */:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
            case 20:
            case Build.API_LEVELS.API_21 /* 21 */:
            case Build.API_LEVELS.API_23 /* 23 */:
            case Build.API_LEVELS.API_26 /* 26 */:
            case Build.API_LEVELS.API_27 /* 27 */:
                i11 = 2;
                break;
            case 10:
            case 11:
            case 12:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case Build.API_LEVELS.API_22 /* 22 */:
            case 24:
            case Build.API_LEVELS.API_25 /* 25 */:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = FirebaseAnalytics.Param.SOURCE;
                break;
            case 5:
                objArr[0] = "contextReceiverParameters";
                break;
            case 6:
                objArr[0] = "typeParameters";
                break;
            case 7:
            case Build.API_LEVELS.API_28 /* 28 */:
            case Build.API_LEVELS.API_30 /* 30 */:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 8:
            case 10:
                objArr[0] = "visibility";
                break;
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
            case 20:
            case Build.API_LEVELS.API_21 /* 21 */:
            case Build.API_LEVELS.API_23 /* 23 */:
            case Build.API_LEVELS.API_26 /* 26 */:
            case Build.API_LEVELS.API_27 /* 27 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 11:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 12:
                objArr[0] = "extensionReceiverParameter";
                break;
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                objArr[0] = "overriddenDescriptors";
                break;
            case Build.API_LEVELS.API_22 /* 22 */:
                objArr[0] = "originalSubstitutor";
                break;
            case 24:
            case Build.API_LEVELS.API_29 /* 29 */:
            case Build.API_LEVELS.API_31 /* 31 */:
                objArr[0] = "substitutor";
                break;
            case Build.API_LEVELS.API_25 /* 25 */:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
            case 9:
                objArr[1] = "initialize";
                break;
            case 10:
            case 11:
            case 12:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case Build.API_LEVELS.API_22 /* 22 */:
            case 24:
            case Build.API_LEVELS.API_25 /* 25 */:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 14:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 15:
                objArr[1] = "getModality";
                break;
            case 16:
                objArr[1] = "getVisibility";
                break;
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                objArr[1] = "getTypeParameters";
                break;
            case 19:
                objArr[1] = "getValueParameters";
                break;
            case 20:
                objArr[1] = "getOriginal";
                break;
            case Build.API_LEVELS.API_21 /* 21 */:
                objArr[1] = "getKind";
                break;
            case Build.API_LEVELS.API_23 /* 23 */:
                objArr[1] = "newCopyBuilder";
                break;
            case Build.API_LEVELS.API_26 /* 26 */:
                objArr[1] = "copy";
                break;
            case Build.API_LEVELS.API_27 /* 27 */:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i10) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
            case 20:
            case Build.API_LEVELS.API_21 /* 21 */:
            case Build.API_LEVELS.API_23 /* 23 */:
            case Build.API_LEVELS.API_26 /* 26 */:
            case Build.API_LEVELS.API_27 /* 27 */:
                break;
            case 10:
                objArr[2] = "setVisibility";
                break;
            case 11:
                objArr[2] = "setReturnType";
                break;
            case 12:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case Build.API_LEVELS.API_22 /* 22 */:
                objArr[2] = "substitute";
                break;
            case 24:
                objArr[2] = "newCopyBuilder";
                break;
            case Build.API_LEVELS.API_25 /* 25 */:
                objArr[2] = "doSubstitute";
                break;
            case Build.API_LEVELS.API_28 /* 28 */:
            case Build.API_LEVELS.API_29 /* 29 */:
            case Build.API_LEVELS.API_30 /* 30 */:
            case Build.API_LEVELS.API_31 /* 31 */:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
            case 20:
            case Build.API_LEVELS.API_21 /* 21 */:
            case Build.API_LEVELS.API_23 /* 23 */:
            case Build.API_LEVELS.API_26 /* 26 */:
            case Build.API_LEVELS.API_27 /* 27 */:
                throw new IllegalStateException(str2);
            case 10:
            case 11:
            case 12:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case Build.API_LEVELS.API_22 /* 22 */:
            case 24:
            case Build.API_LEVELS.API_25 /* 25 */:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // fe.z
    public boolean C0() {
        return this.f12448u;
    }

    @Override // fe.d0
    public boolean E0() {
        return this.f12446s;
    }

    @Override // fe.a
    public boolean H() {
        return this.f12451x;
    }

    public fe.z K0(fe.m mVar, fe.e0 e0Var, fe.u uVar, b.a aVar, boolean z10) {
        fe.z zVarBuild = u().p(mVar).s(e0Var).d(uVar).m(aVar).i(z10).build();
        if (zVarBuild == null) {
            w(26);
        }
        return zVarBuild;
    }

    public abstract s L0(fe.m mVar, fe.z zVar, b.a aVar, ef.f fVar, ge.h hVar, g1 g1Var);

    public fe.z M0(c cVar) {
        char c10;
        n0 n0Var;
        fe.z zVar;
        xf.r0 r0VarP;
        if (cVar == null) {
            w(25);
        }
        boolean[] zArr = new boolean[1];
        ge.h hVarA = cVar.f12475s != null ? ge.j.a(getAnnotations(), cVar.f12475s) : getAnnotations();
        fe.m mVar = cVar.f12458b;
        fe.z zVar2 = cVar.f12461e;
        s sVarL0 = L0(mVar, zVar2, cVar.f12462f, cVar.f12468l, hVarA, N0(cVar.f12471o, zVar2));
        List typeParameters = cVar.f12474r == null ? getTypeParameters() : cVar.f12474r;
        zArr[0] = (zArr[0] ? 1 : 0) | (!typeParameters.isEmpty() ? 1 : 0);
        ArrayList arrayList = new ArrayList(typeParameters.size());
        f2 f2VarC = xf.c0.c(typeParameters, cVar.f12457a, sVarL0, arrayList, zArr);
        b1 b1Var = null;
        if (f2VarC == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!cVar.f12464h.isEmpty()) {
            int i10 = 0;
            for (b1 b1Var2 : cVar.f12464h) {
                xf.r0 r0VarP2 = f2VarC.p(b1Var2.getType(), m2.f25016f);
                if (r0VarP2 == null) {
                    return null;
                }
                int i11 = i10 + 1;
                arrayList2.add(jf.h.b(sVarL0, r0VarP2, ((rf.f) b1Var2.getValue()).a(), b1Var2.getAnnotations(), i10));
                zArr[0] = (zArr[0] ? 1 : 0) | (r0VarP2 != b1Var2.getType() ? (char) 1 : (char) 0);
                i10 = i11;
            }
        }
        b1 b1Var3 = cVar.f12465i;
        if (b1Var3 != null) {
            xf.r0 r0VarP3 = f2VarC.p(b1Var3.getType(), m2.f25016f);
            if (r0VarP3 == null) {
                return null;
            }
            n0 n0Var2 = new n0(sVarL0, new rf.d(sVarL0, r0VarP3, cVar.f12465i.getValue()), cVar.f12465i.getAnnotations());
            zArr[0] = (r0VarP3 != cVar.f12465i.getType() ? (char) 1 : (char) 0) | (zArr[0] ? 1 : 0);
            c10 = 0;
            n0Var = n0Var2;
        } else {
            c10 = 0;
            n0Var = null;
        }
        b1 b1Var4 = cVar.f12466j;
        if (b1Var4 != null) {
            b1 b1VarC = b1Var4.c(f2VarC);
            if (b1VarC == null) {
                return null;
            }
            zArr[c10] = (zArr[c10] ? 1 : 0) | (b1VarC != cVar.f12466j ? (char) 1 : c10);
            zVar = null;
            b1Var = b1VarC;
        } else {
            zVar = null;
        }
        List listP0 = P0(sVarL0, cVar.f12463g, f2VarC, cVar.f12472p, cVar.f12471o, zArr);
        if (listP0 == null || (r0VarP = f2VarC.p(cVar.f12467k, m2.f25017g)) == null) {
            return zVar;
        }
        boolean z10 = (zArr[c10] ? 1 : 0) | (r0VarP != cVar.f12467k ? (char) 1 : c10);
        zArr[c10] = z10;
        if (z10 == 0 && cVar.f12479w) {
            return this;
        }
        sVarL0.R0(n0Var, b1Var, arrayList2, arrayList, listP0, r0VarP, cVar.f12459c, cVar.f12460d);
        sVarL0.f1(this.f12440m);
        sVarL0.c1(this.f12441n);
        sVarL0.X0(this.f12442o);
        sVarL0.e1(this.f12443p);
        sVarL0.i1(this.f12444q);
        sVarL0.h1(this.f12449v);
        sVarL0.W0(this.f12445r);
        sVarL0.V0(this.f12446s);
        sVarL0.Y0(this.f12450w);
        sVarL0.b1(cVar.f12473q);
        sVarL0.a1(cVar.f12476t);
        sVarL0.Z0(cVar.f12478v != null ? cVar.f12478v.booleanValue() : this.f12451x);
        if (!cVar.f12477u.isEmpty() || this.D != null) {
            Map map = cVar.f12477u;
            Map map2 = this.D;
            if (map2 != null) {
                for (Map.Entry entry : map2.entrySet()) {
                    if (!map.containsKey(entry.getKey())) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (map.size() == 1) {
                sVarL0.D = Collections.singletonMap(map.keySet().iterator().next(), map.values().iterator().next());
            } else {
                sVarL0.D = map;
            }
        }
        if (cVar.f12470n || d0() != null) {
            sVarL0.d1((d0() != null ? d0() : this).c(f2VarC));
        }
        if (cVar.f12469m && !a().f().isEmpty()) {
            if (cVar.f12457a.f()) {
                Function0 function0 = this.f12453z;
                if (function0 != null) {
                    sVarL0.f12453z = function0;
                    return sVarL0;
                }
                sVarL0.w0(f());
                return sVarL0;
            }
            sVarL0.f12453z = new a(f2VarC);
        }
        return sVarL0;
    }

    @Override // fe.d0
    public boolean N() {
        return this.f12445r;
    }

    public final g1 N0(boolean z10, fe.z zVar) {
        g1 g1VarJ;
        if (z10) {
            if (zVar == null) {
                zVar = a();
            }
            g1VarJ = zVar.j();
        } else {
            g1VarJ = g1.f9483a;
        }
        if (g1VarJ == null) {
            w(27);
        }
        return g1VarJ;
    }

    public boolean Q0() {
        return this.f12450w;
    }

    public boolean R() {
        return this.f12444q;
    }

    public s R0(b1 b1Var, b1 b1Var2, List list, List list2, List list3, xf.r0 r0Var, fe.e0 e0Var, fe.u uVar) {
        if (list == null) {
            w(5);
        }
        if (list2 == null) {
            w(6);
        }
        if (list3 == null) {
            w(7);
        }
        if (uVar == null) {
            w(8);
        }
        this.f12432e = dd.a0.I0(list2);
        this.f12433f = dd.a0.I0(list3);
        this.f12434g = r0Var;
        this.f12438k = e0Var;
        this.f12439l = uVar;
        this.f12436i = b1Var;
        this.f12437j = b1Var2;
        this.f12435h = list;
        for (int i10 = 0; i10 < list2.size(); i10++) {
            l1 l1Var = (l1) list2.get(i10);
            if (l1Var.getIndex() != i10) {
                throw new IllegalStateException(l1Var + " index is " + l1Var.getIndex() + " but position is " + i10);
            }
        }
        for (int i11 = 0; i11 < list3.size(); i11++) {
            s1 s1Var = (s1) list3.get(i11);
            if (s1Var.getIndex() != i11) {
                throw new IllegalStateException(s1Var + "index is " + s1Var.getIndex() + " but position is " + i11);
            }
        }
        return this;
    }

    public c S0(f2 f2Var) {
        if (f2Var == null) {
            w(24);
        }
        return new c(this, f2Var.j(), b(), l(), getVisibility(), h(), i(), p0(), k0(), getReturnType(), null);
    }

    public final void T0() {
        Function0 function0 = this.f12453z;
        if (function0 != null) {
            this.f12452y = (Collection) function0.invoke();
            this.f12453z = null;
        }
    }

    public void U0(a.InterfaceC0175a interfaceC0175a, Object obj) {
        if (this.D == null) {
            this.D = new LinkedHashMap();
        }
        this.D.put(interfaceC0175a, obj);
    }

    public void V0(boolean z10) {
        this.f12446s = z10;
    }

    public void W0(boolean z10) {
        this.f12445r = z10;
    }

    public void X0(boolean z10) {
        this.f12442o = z10;
    }

    public void Y0(boolean z10) {
        this.f12450w = z10;
    }

    public void Z0(boolean z10) {
        this.f12451x = z10;
    }

    @Override // ie.n, ie.m, fe.m
    public fe.z a() {
        fe.z zVar = this.A;
        fe.z zVarA = zVar == this ? this : zVar.a();
        if (zVarA == null) {
            w(20);
        }
        return zVarA;
    }

    public final void a1(boolean z10) {
        this.f12448u = z10;
    }

    public final void b1(boolean z10) {
        this.f12447t = z10;
    }

    public void c1(boolean z10) {
        this.f12441n = z10;
    }

    @Override // fe.z
    public fe.z d0() {
        return this.C;
    }

    @Override // fe.a
    public b1 e0() {
        return this.f12437j;
    }

    public void e1(boolean z10) {
        this.f12443p = z10;
    }

    public Collection f() {
        T0();
        Collection collection = this.f12452y;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        if (collection == null) {
            w(14);
        }
        return collection;
    }

    public void f1(boolean z10) {
        this.f12440m = z10;
    }

    public void g1(xf.r0 r0Var) {
        if (r0Var == null) {
            w(11);
        }
        this.f12434g = r0Var;
    }

    @Override // fe.a
    public xf.r0 getReturnType() {
        return this.f12434g;
    }

    @Override // fe.a
    public List getTypeParameters() {
        List list = this.f12432e;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // fe.q
    public fe.u getVisibility() {
        fe.u uVar = this.f12439l;
        if (uVar == null) {
            w(16);
        }
        return uVar;
    }

    @Override // fe.b
    public b.a h() {
        b.a aVar = this.B;
        if (aVar == null) {
            w(21);
        }
        return aVar;
    }

    public void h1(boolean z10) {
        this.f12449v = z10;
    }

    @Override // fe.a
    public List i() {
        List list = this.f12433f;
        if (list == null) {
            w(19);
        }
        return list;
    }

    public void i1(boolean z10) {
        this.f12444q = z10;
    }

    public boolean isExternal() {
        return this.f12442o;
    }

    @Override // fe.z
    public boolean isInfix() {
        if (this.f12441n) {
            return true;
        }
        Iterator it = a().f().iterator();
        while (it.hasNext()) {
            if (((fe.z) it.next()).isInfix()) {
                return true;
            }
        }
        return false;
    }

    public boolean isInline() {
        return this.f12443p;
    }

    @Override // fe.z
    public boolean isOperator() {
        if (this.f12440m) {
            return true;
        }
        Iterator it = a().f().iterator();
        while (it.hasNext()) {
            if (((fe.z) it.next()).isOperator()) {
                return true;
            }
        }
        return false;
    }

    @Override // fe.z
    public boolean isSuspend() {
        return this.f12449v;
    }

    public void j1(fe.u uVar) {
        if (uVar == null) {
            w(10);
        }
        this.f12439l = uVar;
    }

    @Override // fe.a
    public b1 k0() {
        return this.f12436i;
    }

    @Override // fe.d0
    public fe.e0 l() {
        fe.e0 e0Var = this.f12438k;
        if (e0Var == null) {
            w(15);
        }
        return e0Var;
    }

    @Override // fe.a
    public List p0() {
        List list = this.f12435h;
        if (list == null) {
            w(13);
        }
        return list;
    }

    public Object t0(fe.o oVar, Object obj) {
        return oVar.d(this, obj);
    }

    public z.a u() {
        c cVarS0 = S0(f2.f24962b);
        if (cVarS0 == null) {
            w(23);
        }
        return cVarS0;
    }

    @Override // fe.z
    public boolean v0() {
        return this.f12447t;
    }

    public void w0(Collection collection) {
        if (collection == null) {
            w(17);
        }
        this.f12452y = collection;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((fe.z) it.next()).C0()) {
                this.f12448u = true;
                return;
            }
        }
    }

    @Override // fe.a
    public Object z(a.InterfaceC0175a interfaceC0175a) {
        Map map = this.D;
        if (map == null) {
            return null;
        }
        return map.get(interfaceC0175a);
    }

    @Override // fe.z, fe.i1
    public fe.z c(f2 f2Var) {
        if (f2Var == null) {
            w(22);
        }
        return f2Var.k() ? this : S0(f2Var).r(a()).e().J(true).build();
    }
}
