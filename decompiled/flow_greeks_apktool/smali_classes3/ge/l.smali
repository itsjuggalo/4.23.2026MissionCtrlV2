.class public final Lge/l;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lge/c;


# instance fields
.field public final a:Lce/i;

.field public final b:Lef/c;

.field public final c:Ljava/util/Map;

.field public final d:Z

.field public final e:Lcd/k;


# direct methods
.method public constructor <init>(Lce/i;Lef/c;Ljava/util/Map;Z)V
    .locals 1

    const-string v0, "builtIns"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "fqName"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "allValueArguments"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    iput-object p1, p0, Lge/l;->a:Lce/i;

    .line 3
    iput-object p2, p0, Lge/l;->b:Lef/c;

    .line 4
    iput-object p3, p0, Lge/l;->c:Ljava/util/Map;

    .line 5
    iput-boolean p4, p0, Lge/l;->d:Z

    .line 6
    sget-object p1, Lcd/n;->b:Lcd/n;

    new-instance p2, Lge/k;

    invoke-direct {p2, p0}, Lge/k;-><init>(Lge/l;)V

    invoke-static {p1, p2}, Lcd/l;->a(Lcd/n;Lkotlin/jvm/functions/Function0;)Lcd/k;

    move-result-object p1

    iput-object p1, p0, Lge/l;->e:Lcd/k;

    return-void
.end method

.method public synthetic constructor <init>(Lce/i;Lef/c;Ljava/util/Map;ZILkotlin/jvm/internal/k;)V
    .locals 0

    and-int/lit8 p5, p5, 0x8

    if-eqz p5, :cond_0

    const/4 p4, 0x0

    .line 7
    :cond_0
    invoke-direct {p0, p1, p2, p3, p4}, Lge/l;-><init>(Lce/i;Lef/c;Ljava/util/Map;Z)V

    return-void
.end method

.method public static synthetic b(Lge/l;)Lxf/c1;
    .locals 0

    .line 1
    invoke-static {p0}, Lge/l;->c(Lge/l;)Lxf/c1;

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

.method public static final c(Lge/l;)Lxf/c1;
    .locals 1

    .line 1
    iget-object v0, p0, Lge/l;->a:Lce/i;

    .line 2
    .line 3
    invoke-virtual {p0}, Lge/l;->e()Lef/c;

    .line 4
    .line 5
    .line 6
    move-result-object p0

    .line 7
    invoke-virtual {v0, p0}, Lce/i;->p(Lef/c;)Lfe/e;

    .line 8
    .line 9
    .line 10
    move-result-object p0

    .line 11
    invoke-interface {p0}, Lfe/e;->s()Lxf/c1;

    .line 12
    .line 13
    .line 14
    move-result-object p0

    .line 15
    return-object p0
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


# virtual methods
.method public a()Ljava/util/Map;
    .locals 1

    .line 1
    iget-object v0, p0, Lge/l;->c:Ljava/util/Map;

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

.method public e()Lef/c;
    .locals 1

    .line 1
    iget-object v0, p0, Lge/l;->b:Lef/c;

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

.method public getType()Lxf/r0;
    .locals 2

    .line 1
    iget-object v0, p0, Lge/l;->e:Lcd/k;

    .line 2
    .line 3
    invoke-interface {v0}, Lcd/k;->getValue()Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    const-string v1, "getValue(...)"

    .line 8
    .line 9
    invoke-static {v0, v1}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 10
    .line 11
    .line 12
    check-cast v0, Lxf/r0;

    .line 13
    .line 14
    return-object v0
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public j()Lfe/g1;
    .locals 2

    .line 1
    sget-object v0, Lfe/g1;->a:Lfe/g1;

    .line 2
    .line 3
    const-string v1, "NO_SOURCE"

    .line 4
    .line 5
    invoke-static {v0, v1}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    return-object v0
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
