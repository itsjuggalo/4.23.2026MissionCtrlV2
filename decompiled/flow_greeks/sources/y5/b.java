package y5;

import m5.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static final d A;
    public static final d B;
    public static final d C;
    public static final d[] D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f25294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f25295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f25296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f25297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f25298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f25299f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f25300g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f25301h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f25302i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final d f25303j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final d f25304k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final d f25305l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final d f25306m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final d f25307n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d f25308o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final d f25309p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final d f25310q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final d f25311r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final d f25312s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final d f25313t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final d f25314u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final d f25315v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final d f25316w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final d f25317x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final d f25318y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final d f25319z;

    static {
        d dVar = new d("cancel_target_direct_transfer", 1L);
        f25294a = dVar;
        d dVar2 = new d("delete_credential", 1L);
        f25295b = dVar2;
        d dVar3 = new d("delete_device_public_key", 1L);
        f25296c = dVar3;
        d dVar4 = new d("get_or_generate_device_public_key", 1L);
        f25297d = dVar4;
        d dVar5 = new d("get_passkeys", 1L);
        f25298e = dVar5;
        d dVar6 = new d("update_passkey", 1L);
        f25299f = dVar6;
        d dVar7 = new d("is_user_verifying_platform_authenticator_available_for_credential", 1L);
        f25300g = dVar7;
        d dVar8 = new d("is_user_verifying_platform_authenticator_available", 1L);
        f25301h = dVar8;
        d dVar9 = new d("privileged_api_list_credentials", 2L);
        f25302i = dVar9;
        d dVar10 = new d("start_target_direct_transfer", 1L);
        f25303j = dVar10;
        d dVar11 = new d("first_party_api_get_link_info", 1L);
        f25304k = dVar11;
        d dVar12 = new d("zero_party_api_register", 3L);
        f25305l = dVar12;
        d dVar13 = new d("zero_party_api_sign", 3L);
        f25306m = dVar13;
        d dVar14 = new d("zero_party_api_list_discoverable_credentials", 2L);
        f25307n = dVar14;
        d dVar15 = new d("zero_party_api_authenticate_passkey", 3L);
        f25308o = dVar15;
        d dVar16 = new d("zero_party_api_register_passkey", 1L);
        f25309p = dVar16;
        d dVar17 = new d("zero_party_api_register_passkey_with_sync_account", 1L);
        f25310q = dVar17;
        d dVar18 = new d("zero_party_api_get_hybrid_client_registration_pending_intent", 1L);
        f25311r = dVar18;
        d dVar19 = new d("zero_party_api_get_hybrid_client_sign_pending_intent", 1L);
        f25312s = dVar19;
        d dVar20 = new d("get_browser_hybrid_client_sign_pending_intent", 1L);
        f25313t = dVar20;
        d dVar21 = new d("get_browser_hybrid_client_registration_pending_intent", 1L);
        f25314u = dVar21;
        d dVar22 = new d("privileged_authenticate_passkey", 2L);
        f25315v = dVar22;
        d dVar23 = new d("privileged_register_passkey_with_sync_account", 1L);
        f25316w = dVar23;
        d dVar24 = new d("zero_party_api_get_privileged_hybrid_client_registration_pending_intent", 1L);
        f25317x = dVar24;
        d dVar25 = new d("zero_party_api_get_privileged_hybrid_client_sign_pending_intent", 1L);
        f25318y = dVar25;
        d dVar26 = new d("zero_party_api_get_fido_security_key_only_sign_pending_intent", 1L);
        f25319z = dVar26;
        d dVar27 = new d("zero_party_api_get_fido_security_key_only_registration_pending_intent", 1L);
        A = dVar27;
        d dVar28 = new d("zero_party_api_get_privileged_fido_security_key_only_sign_pending_intent", 1L);
        B = dVar28;
        d dVar29 = new d("zero_party_api_get_privileged_fido_security_key_only_registration_pending_intent", 1L);
        C = dVar29;
        D = new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8, dVar9, dVar10, dVar11, dVar12, dVar13, dVar14, dVar15, dVar16, dVar17, dVar18, dVar19, dVar20, dVar21, dVar22, dVar23, dVar24, dVar25, dVar26, dVar27, dVar28, dVar29};
    }
}
