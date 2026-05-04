.class public final Lqf/i;
.super Lqf/a;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# instance fields
.field public final b:Lwf/i;


# direct methods
.method public constructor <init>(Lkotlin/jvm/functions/Function0;)V
    .locals 2

    .line 1
    const-string v0, "getScope"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-direct {p0, v0, p1, v1, v0}, Lqf/i;-><init>(Lwf/n;Lkotlin/jvm/functions/Function0;ILkotlin/jvm/internal/k;)V

    return-void
.end method

.method public constructor <init>(Lwf/n;Lkotlin/jvm/functions/Function0;)V
    .locals 1

    const-string v0, "storageManager"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "getScope"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    invoke-direct {p0}, Lqf/a;-><init>()V

    .line 5
    new-instance v0, Lqf/h;

    invoke-direct {v0, p2}, Lqf/h;-><init>(Lkotlin/jvm/functions/Function0;)V

    invoke-interface {p1, v0}, Lwf/n;->e(Lkotlin/jvm/functions/Function0;)Lwf/i;

    move-result-object p1

    iput-object p1, p0, Lqf/i;->b:Lwf/i;

    return-void
.end method

.method public synthetic constructor <init>(Lwf/n;Lkotlin/jvm/functions/Function0;ILkotlin/jvm/internal/k;)V
    .locals 0

    and-int/lit8 p3, p3, 0x1

    if-eqz p3, :cond_0

    .line 2
    sget-object p1, Lwf/f;->e:Lwf/n;

    .line 3
    :cond_0
    invoke-direct {p0, p1, p2}, Lqf/i;-><init>(Lwf/n;Lkotlin/jvm/functions/Function0;)V

    return-void
.end method

.method public static synthetic j(Lkotlin/jvm/functions/Function0;)Lqf/k;
    .locals 0

    .line 1
    invoke-static {p0}, Lqf/i;->k(Lkotlin/jvm/functions/Function0;)Lqf/k;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static final k(Lkotlin/jvm/functions/Function0;)Lqf/k;
    .locals 1

    .line 1
    invoke-interface {p0}, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    check-cast p0, Lqf/k;

    .line 6
    .line 7
    instance-of v0, p0, Lqf/a;

    .line 8
    .line 9
    if-eqz v0, :cond_0

    .line 10
    .line 11
    check-cast p0, Lqf/a;

    .line 12
    .line 13
    invoke-virtual {p0}, Lqf/a;->h()Lqf/k;

    .line 14
    .line 15
    .line 16
    move-result-object p0

    .line 17
    :cond_0
    return-object p0
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method


# virtual methods
.method public i()Lqf/k;
    .locals 1

    .line 1
    iget-object v0, p0, Lqf/i;->b:Lwf/i;

    .line 2
    .line 3
    invoke-interface {v0}, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Lqf/k;

    .line 8
    .line 9
    return-object v0
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
