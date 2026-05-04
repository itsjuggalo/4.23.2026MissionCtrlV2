.class public final Lxe/k;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lxe/k$a;
    }
.end annotation


# static fields
.field public static final b:Lxe/k$a;


# instance fields
.field public final a:Ltf/n;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lxe/k$a;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    invoke-direct {v0, v1}, Lxe/k$a;-><init>(Lkotlin/jvm/internal/k;)V

    .line 5
    .line 6
    .line 7
    sput-object v0, Lxe/k;->b:Lxe/k$a;

    .line 8
    .line 9
    return-void
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

.method public constructor <init>(Lwf/n;Lfe/h0;Ltf/o;Lxe/o;Lxe/h;Lre/j;Lfe/m0;Ltf/w;Lne/c;Ltf/m;Lyf/p;Lag/a;)V
    .locals 21

    move-object/from16 v1, p1

    const-string v0, "storageManager"

    invoke-static {v1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "moduleDescriptor"

    move-object/from16 v2, p2

    invoke-static {v2, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "configuration"

    move-object/from16 v3, p3

    invoke-static {v3, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "classDataFinder"

    move-object/from16 v4, p4

    invoke-static {v4, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "annotationAndConstantLoader"

    move-object/from16 v5, p5

    invoke-static {v5, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "packageFragmentProvider"

    move-object/from16 v6, p6

    invoke-static {v6, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "notFoundClasses"

    move-object/from16 v12, p7

    invoke-static {v12, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "errorReporter"

    move-object/from16 v8, p8

    invoke-static {v8, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "lookupTracker"

    move-object/from16 v9, p9

    invoke-static {v9, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "contractDeserializer"

    move-object/from16 v13, p10

    invoke-static {v13, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "kotlinTypeChecker"

    move-object/from16 v7, p11

    invoke-static {v7, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "typeAttributeTranslators"

    move-object/from16 v10, p12

    invoke-static {v10, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 2
    invoke-interface {v2}, Lfe/h0;->p()Lce/i;

    move-result-object v0

    instance-of v11, v0, Lee/k;

    if-eqz v11, :cond_0

    check-cast v0, Lee/k;

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    .line 3
    :goto_0
    new-instance v11, Ltf/n;

    .line 4
    sget-object v7, Ltf/b0$a;->a:Ltf/b0$a;

    sget-object v10, Lxe/p;->a:Lxe/p;

    move-object v14, v0

    move-object v0, v11

    .line 5
    invoke-static {}, Ldd/r;->k()Ljava/util/List;

    move-result-object v11

    if-eqz v14, :cond_1

    .line 6
    invoke-virtual {v14}, Lee/k;->M0()Lee/u;

    move-result-object v15

    if-eqz v15, :cond_1

    goto :goto_1

    :cond_1
    sget-object v15, Lhe/a$a;->a:Lhe/a$a;

    :goto_1
    if-eqz v14, :cond_2

    .line 7
    invoke-virtual {v14}, Lee/k;->M0()Lee/u;

    move-result-object v14

    if-eqz v14, :cond_2

    goto :goto_2

    :cond_2
    sget-object v14, Lhe/c$b;->a:Lhe/c$b;

    .line 8
    :goto_2
    sget-object v16, Ldf/i;->a:Ldf/i;

    invoke-virtual/range {v16 .. v16}, Ldf/i;->a()Lgf/g;

    move-result-object v16

    move-object/from16 v17, v0

    .line 9
    new-instance v0, Lpf/b;

    invoke-static {}, Ldd/r;->k()Ljava/util/List;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lpf/b;-><init>(Lwf/n;Ljava/lang/Iterable;)V

    .line 10
    invoke-virtual/range {p12 .. p12}, Lag/a;->a()Ljava/util/List;

    move-result-object v19

    .line 11
    sget-object v20, Ltf/z;->a:Ltf/z;

    move-object v2, v15

    move-object v15, v14

    move-object v14, v2

    move-object/from16 v2, p2

    move-object/from16 v18, v0

    move-object/from16 v0, v17

    move-object/from16 v17, p11

    .line 12
    invoke-direct/range {v0 .. v20}, Ltf/n;-><init>(Lwf/n;Lfe/h0;Ltf/o;Ltf/j;Ltf/e;Lfe/o0;Ltf/b0;Ltf/w;Lne/c;Ltf/x;Ljava/lang/Iterable;Lfe/m0;Ltf/m;Lhe/a;Lhe/c;Lgf/g;Lyf/p;Lpf/a;Ljava/util/List;Ltf/v;)V

    move-object v1, v0

    move-object/from16 v0, p0

    iput-object v1, v0, Lxe/k;->a:Ltf/n;

    return-void
.end method


# virtual methods
.method public final a()Ltf/n;
    .locals 1

    .line 1
    iget-object v0, p0, Lxe/k;->a:Ltf/n;

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
