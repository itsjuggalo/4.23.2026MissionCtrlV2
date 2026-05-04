package io.flutter.plugins.firebase.auth;

import android.net.Uri;
import io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import m7.e;
import m7.n0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class PigeonParser {
    public static m7.e getActionCodeSettings(GeneratedAndroidFirebaseAuth.PigeonActionCodeSettings pigeonActionCodeSettings) {
        e.a aVarY = m7.e.Y();
        aVarY.g(pigeonActionCodeSettings.getUrl());
        if (pigeonActionCodeSettings.getDynamicLinkDomain() != null) {
            aVarY.c(pigeonActionCodeSettings.getDynamicLinkDomain());
        }
        if (pigeonActionCodeSettings.getLinkDomain() != null) {
            aVarY.f(pigeonActionCodeSettings.getLinkDomain());
        }
        aVarY.d(pigeonActionCodeSettings.getHandleCodeInApp().booleanValue());
        if (pigeonActionCodeSettings.getAndroidPackageName() != null) {
            aVarY.b(pigeonActionCodeSettings.getAndroidPackageName(), pigeonActionCodeSettings.getAndroidInstallApp().booleanValue(), pigeonActionCodeSettings.getAndroidMinimumVersion());
        }
        if (pigeonActionCodeSettings.getIOSBundleId() != null) {
            aVarY.e(pigeonActionCodeSettings.getIOSBundleId());
        }
        return aVarY.a();
    }

    public static m7.h getCredential(Map<String, Object> map) {
        String str;
        String str2;
        String str3;
        String str4;
        if (map.get("token") != null) {
            Integer num = (Integer) map.get("token");
            num.intValue();
            m7.h hVar = FlutterFirebaseAuthPlugin.authCredentials.get(num);
            if (hVar != null) {
                return hVar;
            }
            throw FlutterFirebaseAuthPluginException.invalidCredential();
        }
        Object obj = map.get(Constants.SIGN_IN_METHOD);
        Objects.requireNonNull(obj);
        String str5 = (String) obj;
        str = (String) map.get(Constants.SECRET);
        str2 = (String) map.get(Constants.ID_TOKEN);
        str3 = (String) map.get(Constants.ACCESS_TOKEN);
        str4 = (String) map.get(Constants.RAW_NONCE);
        switch (str5) {
            case "twitter.com":
                Objects.requireNonNull(str3);
                Objects.requireNonNull(str);
                return m7.a1.a(str3, str);
            case "playgames.google.com":
                Object obj2 = map.get(Constants.SERVER_AUTH_CODE);
                Objects.requireNonNull(obj2);
                return m7.t0.a((String) obj2);
            case "google.com":
                return m7.g0.a(str2, str3);
            case "facebook.com":
                Objects.requireNonNull(str3);
                return m7.m.a(str3);
            case "oauth":
                Object obj3 = map.get(Constants.PROVIDER_ID);
                Objects.requireNonNull(obj3);
                n0.b bVarF = m7.n0.f((String) obj3);
                if (str3 != null) {
                    bVarF.b(str3);
                }
                if (str4 == null) {
                    Objects.requireNonNull(str2);
                    bVarF.c(str2);
                } else {
                    Objects.requireNonNull(str2);
                    bVarF.d(str2, str4);
                }
                return bVarF.a();
            case "phone":
                Object obj4 = map.get(Constants.VERIFICATION_ID);
                Objects.requireNonNull(obj4);
                Object obj5 = map.get(Constants.SMS_CODE);
                Objects.requireNonNull(obj5);
                return com.google.firebase.auth.b.a((String) obj4, (String) obj5);
            case "password":
                Object obj6 = map.get(Constants.EMAIL);
                Objects.requireNonNull(obj6);
                Objects.requireNonNull(str);
                return m7.k.a((String) obj6, str);
            case "github.com":
                Objects.requireNonNull(str3);
                return m7.e0.a(str3);
            case "emailLink":
                Object obj7 = map.get(Constants.EMAIL);
                Objects.requireNonNull(obj7);
                Object obj8 = map.get("emailLink");
                Objects.requireNonNull(obj8);
                return m7.k.b((String) obj7, (String) obj8);
            default:
                return null;
        }
    }

    public static List<Object> manuallyToList(GeneratedAndroidFirebaseAuth.PigeonUserDetails pigeonUserDetails) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(pigeonUserDetails.getUserInfo().toList());
        arrayList.add(pigeonUserDetails.getProviderData());
        return arrayList;
    }

    public static List<List<Object>> multiFactorInfoToMap(List<m7.j0> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<GeneratedAndroidFirebaseAuth.PigeonMultiFactorInfo> it = multiFactorInfoToPigeon(list).iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toList());
        }
        return arrayList;
    }

    public static List<GeneratedAndroidFirebaseAuth.PigeonMultiFactorInfo> multiFactorInfoToPigeon(List<m7.j0> list) {
        ArrayList arrayList = new ArrayList();
        for (m7.j0 j0Var : list) {
            if (j0Var instanceof m7.r0) {
                arrayList.add(new GeneratedAndroidFirebaseAuth.PigeonMultiFactorInfo.Builder().setPhoneNumber(((m7.r0) j0Var).p()).setDisplayName(j0Var.v()).setEnrollmentTimestamp(Double.valueOf(j0Var.R())).setUid(j0Var.a()).setFactorId(j0Var.S()).build());
            } else {
                arrayList.add(new GeneratedAndroidFirebaseAuth.PigeonMultiFactorInfo.Builder().setDisplayName(j0Var.v()).setEnrollmentTimestamp(Double.valueOf(j0Var.R())).setUid(j0Var.a()).setFactorId(j0Var.S()).build());
            }
        }
        return arrayList;
    }

    public static GeneratedAndroidFirebaseAuth.PigeonActionCodeInfo parseActionCodeResult(m7.d dVar) {
        GeneratedAndroidFirebaseAuth.PigeonActionCodeInfo.Builder builder = new GeneratedAndroidFirebaseAuth.PigeonActionCodeInfo.Builder();
        GeneratedAndroidFirebaseAuth.PigeonActionCodeInfoData.Builder builder2 = new GeneratedAndroidFirebaseAuth.PigeonActionCodeInfoData.Builder();
        int iA = dVar.a();
        if (iA == 0) {
            builder.setOperation(GeneratedAndroidFirebaseAuth.ActionCodeInfoOperation.PASSWORD_RESET);
        } else if (iA == 1) {
            builder.setOperation(GeneratedAndroidFirebaseAuth.ActionCodeInfoOperation.VERIFY_EMAIL);
        } else if (iA == 2) {
            builder.setOperation(GeneratedAndroidFirebaseAuth.ActionCodeInfoOperation.RECOVER_EMAIL);
        } else if (iA == 4) {
            builder.setOperation(GeneratedAndroidFirebaseAuth.ActionCodeInfoOperation.EMAIL_SIGN_IN);
        } else if (iA == 5) {
            builder.setOperation(GeneratedAndroidFirebaseAuth.ActionCodeInfoOperation.VERIFY_AND_CHANGE_EMAIL);
        } else if (iA == 6) {
            builder.setOperation(GeneratedAndroidFirebaseAuth.ActionCodeInfoOperation.REVERT_SECOND_FACTOR_ADDITION);
        }
        m7.b bVarB = dVar.b();
        if ((bVarB != null && iA == 1) || iA == 0) {
            builder2.setEmail(bVarB.a());
        } else if (iA == 2 || iA == 5) {
            Objects.requireNonNull(bVarB);
            m7.a aVar = (m7.a) bVarB;
            builder2.setEmail(aVar.a());
            builder2.setPreviousEmail(aVar.b());
        }
        builder.setData(builder2.build());
        return builder.build();
    }

    private static GeneratedAndroidFirebaseAuth.PigeonAdditionalUserInfo parseAdditionalUserInfo(m7.g gVar) {
        if (gVar == null) {
            return null;
        }
        GeneratedAndroidFirebaseAuth.PigeonAdditionalUserInfo.Builder builder = new GeneratedAndroidFirebaseAuth.PigeonAdditionalUserInfo.Builder();
        builder.setIsNewUser(Boolean.valueOf(gVar.L()));
        builder.setProfile(gVar.getProfile());
        builder.setProviderId(gVar.c());
        builder.setUsername(gVar.s());
        return builder.build();
    }

    public static GeneratedAndroidFirebaseAuth.PigeonAuthCredential parseAuthCredential(m7.h hVar) {
        if (hVar == null) {
            return null;
        }
        int iHashCode = hVar.hashCode();
        FlutterFirebaseAuthPlugin.authCredentials.put(Integer.valueOf(iHashCode), hVar);
        GeneratedAndroidFirebaseAuth.PigeonAuthCredential.Builder builder = new GeneratedAndroidFirebaseAuth.PigeonAuthCredential.Builder();
        builder.setProviderId(hVar.R());
        builder.setSignInMethod(hVar.S());
        builder.setNativeId(Long.valueOf(iHashCode));
        if (hVar instanceof m7.m0) {
            builder.setAccessToken(((m7.m0) hVar).U());
        }
        return builder.build();
    }

    public static GeneratedAndroidFirebaseAuth.PigeonUserCredential parseAuthResult(m7.i iVar) {
        GeneratedAndroidFirebaseAuth.PigeonUserCredential.Builder builder = new GeneratedAndroidFirebaseAuth.PigeonUserCredential.Builder();
        builder.setAdditionalUserInfo(parseAdditionalUserInfo(iVar.y()));
        builder.setCredential(parseAuthCredential(iVar.A()));
        builder.setUser(parseFirebaseUser(iVar.G()));
        return builder.build();
    }

    public static GeneratedAndroidFirebaseAuth.PigeonUserDetails parseFirebaseUser(m7.a0 a0Var) {
        if (a0Var == null) {
            return null;
        }
        GeneratedAndroidFirebaseAuth.PigeonUserDetails.Builder builder = new GeneratedAndroidFirebaseAuth.PigeonUserDetails.Builder();
        GeneratedAndroidFirebaseAuth.PigeonUserInfo.Builder builder2 = new GeneratedAndroidFirebaseAuth.PigeonUserInfo.Builder();
        builder2.setDisplayName(a0Var.v());
        builder2.setEmail(a0Var.K());
        builder2.setIsEmailVerified(Boolean.valueOf(a0Var.f()));
        builder2.setIsAnonymous(Boolean.valueOf(a0Var.X()));
        if (a0Var.T() != null) {
            builder2.setCreationTimestamp(Long.valueOf(a0Var.T().q()));
            builder2.setLastSignInTimestamp(Long.valueOf(a0Var.T().w()));
        }
        builder2.setPhoneNumber(a0Var.p());
        builder2.setPhotoUrl(parsePhotoUrl(a0Var.d()));
        builder2.setUid(a0Var.a());
        builder2.setTenantId(a0Var.W());
        builder.setUserInfo(builder2.build());
        builder.setProviderData(parseUserInfoList(a0Var.V()));
        return builder.build();
    }

    private static String parsePhotoUrl(Uri uri) {
        if (uri == null) {
            return null;
        }
        String string = uri.toString();
        if ("".equals(string)) {
            return null;
        }
        return string;
    }

    public static GeneratedAndroidFirebaseAuth.PigeonIdTokenResult parseTokenResult(m7.c0 c0Var) {
        GeneratedAndroidFirebaseAuth.PigeonIdTokenResult.Builder builder = new GeneratedAndroidFirebaseAuth.PigeonIdTokenResult.Builder();
        builder.setToken(c0Var.g());
        builder.setSignInProvider(c0Var.e());
        builder.setAuthTimestamp(Long.valueOf(c0Var.a() * 1000));
        builder.setExpirationTimestamp(Long.valueOf(c0Var.c() * 1000));
        builder.setIssuedAtTimestamp(Long.valueOf(c0Var.d() * 1000));
        builder.setClaims(c0Var.b());
        builder.setSignInSecondFactor(c0Var.f());
        return builder.build();
    }

    private static List<Map<Object, Object>> parseUserInfoList(List<? extends m7.b1> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return null;
        }
        for (m7.b1 b1Var : new ArrayList(list)) {
            if (b1Var != null && !"firebase".equals(b1Var.c())) {
                arrayList.add(parseUserInfoToMap(b1Var));
            }
        }
        return arrayList;
    }

    private static Map<Object, Object> parseUserInfoToMap(m7.b1 b1Var) {
        HashMap map = new HashMap();
        map.put("displayName", b1Var.v());
        map.put(Constants.EMAIL, b1Var.K());
        map.put("isEmailVerified", Boolean.valueOf(b1Var.f()));
        map.put("phoneNumber", b1Var.p());
        map.put("photoUrl", parsePhotoUrl(b1Var.d()));
        map.put("uid", b1Var.a() == null ? "" : b1Var.a());
        map.put(Constants.PROVIDER_ID, b1Var.c());
        map.put("isAnonymous", Boolean.FALSE);
        return map;
    }
}
