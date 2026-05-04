.class public final Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter$$serializer;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ldh/e0;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "$serializer"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ldh/e0;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u00c7\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\t\u0008\u0002\u00a2\u0006\u0004\u0008\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00060\u0005H\u00d6\u0001\u00a2\u0006\u0004\u0008\u0007\u0010\u0008J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u00d6\u0001\u00a2\u0006\u0004\u0008\u000b\u0010\u000cJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VX\u00d6\u0005\u00a2\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015\u00a8\u0006\u0017"
    }
    d2 = {
        "com/revenuecat/purchases/common/events/BackendEvent.CustomerCenter.$serializer",
        "Ldh/e0;",
        "Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;",
        "<init>",
        "()V",
        "",
        "Lzg/b;",
        "childSerializers",
        "()[Lzg/b;",
        "Lch/e;",
        "decoder",
        "deserialize",
        "(Lch/e;)Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;",
        "Lch/f;",
        "encoder",
        "value",
        "Lcd/h0;",
        "serialize",
        "(Lch/f;Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;)V",
        "Lbh/e;",
        "getDescriptor",
        "()Lbh/e;",
        "descriptor",
        "purchases_defaultsBc8Release"
    }
    k = 0x1
    mv = {
        0x1,
        0x8,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field public static final INSTANCE:Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter$$serializer;

.field private static final synthetic descriptor:Ldh/j1;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .line 1
    new-instance v0, Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter$$serializer;

    .line 2
    .line 3
    invoke-direct {v0}, Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter$$serializer;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter$$serializer;->INSTANCE:Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter$$serializer;

    .line 7
    .line 8
    new-instance v1, Ldh/j1;

    .line 9
    .line 10
    const-string v2, "customer_center"

    .line 11
    .line 12
    const/16 v3, 0xc

    .line 13
    .line 14
    invoke-direct {v1, v2, v0, v3}, Ldh/j1;-><init>(Ljava/lang/String;Ldh/e0;I)V

    .line 15
    .line 16
    .line 17
    const-string v0, "id"

    .line 18
    .line 19
    const/4 v2, 0x0

    .line 20
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 21
    .line 22
    .line 23
    const-string v0, "revision_id"

    .line 24
    .line 25
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 26
    .line 27
    .line 28
    const-string v0, "type"

    .line 29
    .line 30
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 31
    .line 32
    .line 33
    const-string v0, "app_user_id"

    .line 34
    .line 35
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 36
    .line 37
    .line 38
    const-string v0, "app_session_id"

    .line 39
    .line 40
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 41
    .line 42
    .line 43
    const-string v0, "timestamp"

    .line 44
    .line 45
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 46
    .line 47
    .line 48
    const-string v0, "dark_mode"

    .line 49
    .line 50
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 51
    .line 52
    .line 53
    const-string v0, "locale"

    .line 54
    .line 55
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 56
    .line 57
    .line 58
    const-string v0, "display_mode"

    .line 59
    .line 60
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 61
    .line 62
    .line 63
    const-string v0, "path"

    .line 64
    .line 65
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 66
    .line 67
    .line 68
    const-string v0, "url"

    .line 69
    .line 70
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 71
    .line 72
    .line 73
    const-string v0, "survey_option_id"

    .line 74
    .line 75
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 76
    .line 77
    .line 78
    sput-object v1, Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter$$serializer;->descriptor:Ldh/j1;

    .line 79
    .line 80
    return-void
    .line 81
    .line 82
.end method

.method private constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    return-void
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method


# virtual methods
.method public childSerializers()[Lzg/b;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()[",
            "Lzg/b;"
        }
    .end annotation

    .line 1
    invoke-static {}, Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;->access$get$childSerializers$cp()[Lzg/b;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    sget-object v1, Ldh/w1;->a:Ldh/w1;

    .line 6
    .line 7
    const/4 v2, 0x2

    .line 8
    aget-object v3, v0, v2

    .line 9
    .line 10
    const/16 v4, 0x8

    .line 11
    .line 12
    aget-object v5, v0, v4

    .line 13
    .line 14
    const/16 v6, 0x9

    .line 15
    .line 16
    aget-object v0, v0, v6

    .line 17
    .line 18
    invoke-static {v0}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 19
    .line 20
    .line 21
    move-result-object v0

    .line 22
    invoke-static {v1}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 23
    .line 24
    .line 25
    move-result-object v7

    .line 26
    invoke-static {v1}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 27
    .line 28
    .line 29
    move-result-object v8

    .line 30
    const/16 v9, 0xc

    .line 31
    .line 32
    new-array v9, v9, [Lzg/b;

    .line 33
    .line 34
    const/4 v10, 0x0

    .line 35
    aput-object v1, v9, v10

    .line 36
    .line 37
    sget-object v10, Ldh/j0;->a:Ldh/j0;

    .line 38
    .line 39
    const/4 v11, 0x1

    .line 40
    aput-object v10, v9, v11

    .line 41
    .line 42
    aput-object v3, v9, v2

    .line 43
    .line 44
    const/4 v2, 0x3

    .line 45
    aput-object v1, v9, v2

    .line 46
    .line 47
    const/4 v2, 0x4

    .line 48
    aput-object v1, v9, v2

    .line 49
    .line 50
    sget-object v2, Ldh/q0;->a:Ldh/q0;

    .line 51
    .line 52
    const/4 v3, 0x5

    .line 53
    aput-object v2, v9, v3

    .line 54
    .line 55
    sget-object v2, Ldh/h;->a:Ldh/h;

    .line 56
    .line 57
    const/4 v3, 0x6

    .line 58
    aput-object v2, v9, v3

    .line 59
    .line 60
    const/4 v2, 0x7

    .line 61
    aput-object v1, v9, v2

    .line 62
    .line 63
    aput-object v5, v9, v4

    .line 64
    .line 65
    aput-object v0, v9, v6

    .line 66
    .line 67
    const/16 v0, 0xa

    .line 68
    .line 69
    aput-object v7, v9, v0

    .line 70
    .line 71
    const/16 v0, 0xb

    .line 72
    .line 73
    aput-object v8, v9, v0

    .line 74
    .line 75
    return-object v9
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
.end method

.method public deserialize(Lch/e;)Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;
    .locals 42

    move-object/from16 v0, p1

    const-string v1, "decoder"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter$$serializer;->getDescriptor()Lbh/e;

    move-result-object v1

    invoke-interface {v0, v1}, Lch/e;->b(Lbh/e;)Lch/c;

    move-result-object v0

    invoke-static {}, Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;->access$get$childSerializers$cp()[Lzg/b;

    move-result-object v2

    invoke-interface {v0}, Lch/c;->z()Z

    move-result v3

    const/16 v5, 0xa

    const/4 v6, 0x7

    const/4 v7, 0x6

    const/4 v8, 0x5

    const/4 v9, 0x3

    const/4 v10, 0x4

    const/16 v11, 0x9

    const/16 v12, 0x8

    const/4 v13, 0x2

    const/4 v14, 0x1

    const/4 v15, 0x0

    const/4 v4, 0x0

    if-eqz v3, :cond_0

    invoke-interface {v0, v1, v15}, Lch/c;->s(Lbh/e;I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v1, v14}, Lch/c;->C(Lbh/e;I)I

    move-result v14

    aget-object v15, v2, v13

    invoke-interface {v0, v1, v13, v15, v4}, Lch/c;->h(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterEventType;

    invoke-interface {v0, v1, v9}, Lch/c;->s(Lbh/e;I)Ljava/lang/String;

    move-result-object v9

    invoke-interface {v0, v1, v10}, Lch/c;->s(Lbh/e;I)Ljava/lang/String;

    move-result-object v10

    invoke-interface {v0, v1, v8}, Lch/c;->g(Lbh/e;I)J

    move-result-wide v15

    invoke-interface {v0, v1, v7}, Lch/c;->B(Lbh/e;I)Z

    move-result v7

    invoke-interface {v0, v1, v6}, Lch/c;->s(Lbh/e;I)Ljava/lang/String;

    move-result-object v6

    aget-object v8, v2, v12

    invoke-interface {v0, v1, v12, v8, v4}, Lch/c;->h(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterDisplayMode;

    aget-object v2, v2, v11

    invoke-interface {v0, v1, v11, v2, v4}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;

    sget-object v11, Ldh/w1;->a:Ldh/w1;

    invoke-interface {v0, v1, v5, v11, v4}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    const/16 v12, 0xb

    invoke-interface {v0, v1, v12, v11, v4}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    const/16 v11, 0xfff

    move-object/from16 v38, v2

    move-object/from16 v28, v3

    move-object/from16 v40, v4

    move-object/from16 v39, v5

    move-object/from16 v36, v6

    move/from16 v35, v7

    move-object/from16 v37, v8

    move-object/from16 v31, v9

    move-object/from16 v32, v10

    move/from16 v27, v11

    move-object/from16 v30, v13

    move/from16 v29, v14

    move-wide/from16 v33, v15

    goto/16 :goto_6

    :cond_0
    const-wide/16 v16, 0x0

    move-object v3, v4

    move-object v9, v3

    move-object/from16 v18, v9

    move/from16 v20, v13

    move/from16 v25, v14

    move v10, v15

    move/from16 v21, v10

    move/from16 v22, v21

    move-wide/from16 v23, v16

    move-object/from16 v13, v18

    move-object v14, v13

    move-object v15, v14

    move-object/from16 v16, v15

    move-object/from16 v17, v16

    :goto_0
    if-eqz v25, :cond_1

    invoke-interface {v0, v1}, Lch/c;->w(Lbh/e;)I

    move-result v8

    packed-switch v8, :pswitch_data_0

    new-instance v0, Lzg/m;

    invoke-direct {v0, v8}, Lzg/m;-><init>(I)V

    throw v0

    :pswitch_0
    sget-object v8, Ldh/w1;->a:Ldh/w1;

    const/16 v7, 0xb

    invoke-interface {v0, v1, v7, v8, v9}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    move-object v9, v8

    check-cast v9, Ljava/lang/String;

    or-int/lit16 v10, v10, 0x800

    :goto_1
    const/4 v7, 0x6

    :goto_2
    const/4 v8, 0x5

    goto :goto_0

    :pswitch_1
    const/16 v7, 0xb

    sget-object v8, Ldh/w1;->a:Ldh/w1;

    invoke-interface {v0, v1, v5, v8, v13}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    move-object v13, v8

    check-cast v13, Ljava/lang/String;

    or-int/lit16 v10, v10, 0x400

    goto :goto_1

    :pswitch_2
    const/16 v7, 0xb

    aget-object v8, v2, v11

    invoke-interface {v0, v1, v11, v8, v14}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    move-object v14, v8

    check-cast v14, Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;

    or-int/lit16 v10, v10, 0x200

    goto :goto_1

    :pswitch_3
    const/16 v7, 0xb

    aget-object v8, v2, v12

    invoke-interface {v0, v1, v12, v8, v15}, Lch/c;->h(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    move-object v15, v8

    check-cast v15, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterDisplayMode;

    or-int/lit16 v10, v10, 0x100

    goto :goto_1

    :pswitch_4
    const/16 v7, 0xb

    invoke-interface {v0, v1, v6}, Lch/c;->s(Lbh/e;I)Ljava/lang/String;

    move-result-object v18

    or-int/lit16 v10, v10, 0x80

    goto :goto_1

    :pswitch_5
    move v8, v7

    const/16 v7, 0xb

    invoke-interface {v0, v1, v8}, Lch/c;->B(Lbh/e;I)Z

    move-result v21

    or-int/lit8 v10, v10, 0x40

    move v7, v8

    goto :goto_2

    :pswitch_6
    move v8, v7

    const/4 v5, 0x5

    const/16 v7, 0xb

    invoke-interface {v0, v1, v5}, Lch/c;->g(Lbh/e;I)J

    move-result-wide v23

    or-int/lit8 v10, v10, 0x20

    move v7, v8

    move v8, v5

    const/16 v5, 0xa

    goto :goto_0

    :pswitch_7
    move v8, v7

    const/4 v5, 0x4

    const/16 v7, 0xb

    invoke-interface {v0, v1, v5}, Lch/c;->s(Lbh/e;I)Ljava/lang/String;

    move-result-object v17

    or-int/lit8 v10, v10, 0x10

    :goto_3
    move v7, v8

    const/16 v5, 0xa

    goto :goto_2

    :pswitch_8
    move v8, v7

    const/4 v5, 0x3

    const/16 v7, 0xb

    invoke-interface {v0, v1, v5}, Lch/c;->s(Lbh/e;I)Ljava/lang/String;

    move-result-object v16

    or-int/lit8 v10, v10, 0x8

    goto :goto_3

    :pswitch_9
    move v8, v7

    const/16 v7, 0xb

    aget-object v5, v2, v20

    move/from16 v6, v20

    invoke-interface {v0, v1, v6, v5, v3}, Lch/c;->h(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterEventType;

    or-int/lit8 v10, v10, 0x4

    :goto_4
    move v7, v8

    :goto_5
    const/16 v5, 0xa

    const/4 v6, 0x7

    goto :goto_2

    :pswitch_a
    move v8, v7

    move/from16 v6, v20

    const/4 v5, 0x1

    const/16 v7, 0xb

    invoke-interface {v0, v1, v5}, Lch/c;->C(Lbh/e;I)I

    move-result v22

    or-int/lit8 v10, v10, 0x2

    goto :goto_4

    :pswitch_b
    move v8, v7

    move/from16 v6, v20

    const/4 v4, 0x0

    const/4 v5, 0x1

    const/16 v7, 0xb

    invoke-interface {v0, v1, v4}, Lch/c;->s(Lbh/e;I)Ljava/lang/String;

    move-result-object v19

    or-int/lit8 v10, v10, 0x1

    move v7, v8

    move-object/from16 v4, v19

    goto :goto_5

    :pswitch_c
    move v8, v7

    const/16 v19, 0x0

    move/from16 v25, v19

    goto/16 :goto_2

    :cond_1
    move-object/from16 v30, v3

    move-object/from16 v28, v4

    move-object/from16 v40, v9

    move/from16 v27, v10

    move-object/from16 v39, v13

    move-object/from16 v38, v14

    move-object/from16 v37, v15

    move-object/from16 v31, v16

    move-object/from16 v32, v17

    move-object/from16 v36, v18

    move/from16 v35, v21

    move/from16 v29, v22

    move-wide/from16 v33, v23

    :goto_6
    invoke-interface {v0, v1}, Lch/c;->c(Lbh/e;)V

    new-instance v26, Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;

    const/16 v41, 0x0

    invoke-direct/range {v26 .. v41}, Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;-><init>(ILjava/lang/String;ILcom/revenuecat/purchases/customercenter/events/CustomerCenterEventType;Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Lcom/revenuecat/purchases/customercenter/events/CustomerCenterDisplayMode;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;Ljava/lang/String;Ljava/lang/String;Ldh/s1;)V

    return-object v26

    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public bridge synthetic deserialize(Lch/e;)Ljava/lang/Object;
    .locals 0

    .line 2
    invoke-virtual {p0, p1}, Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter$$serializer;->deserialize(Lch/e;)Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;

    move-result-object p1

    return-object p1
.end method

.method public getDescriptor()Lbh/e;
    .locals 1

    .line 1
    sget-object v0, Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter$$serializer;->descriptor:Ldh/j1;

    .line 2
    .line 3
    return-object v0
    .line 4
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public serialize(Lch/f;Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;)V
    .locals 1

    const-string v0, "encoder"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "value"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1
    invoke-virtual {p0}, Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter$$serializer;->getDescriptor()Lbh/e;

    move-result-object v0

    invoke-interface {p1, v0}, Lch/f;->b(Lbh/e;)Lch/d;

    move-result-object p1

    invoke-static {p2, p1, v0}, Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;->write$Self$purchases_defaultsBc8Release(Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;Lch/d;Lbh/e;)V

    invoke-interface {p1, v0}, Lch/d;->c(Lbh/e;)V

    return-void
.end method

.method public bridge synthetic serialize(Lch/f;Ljava/lang/Object;)V
    .locals 0

    .line 2
    check-cast p2, Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;

    invoke-virtual {p0, p1, p2}, Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter$$serializer;->serialize(Lch/f;Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;)V

    return-void
.end method

.method public typeParametersSerializers()[Lzg/b;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()[",
            "Lzg/b;"
        }
    .end annotation

    .line 1
    invoke-static {p0}, Ldh/e0$a;->a(Ldh/e0;)[Lzg/b;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    return-object v0
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method
