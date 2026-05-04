.class public final Lw9/b$c;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lw9/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "c"
.end annotation


# instance fields
.field public a:Lx9/e;

.field public b:Lx9/c;

.field public c:Lw9/f;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lw9/b$a;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lw9/b$c;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Lw9/a;
    .locals 5

    .line 1
    iget-object v0, p0, Lw9/b$c;->a:Lx9/e;

    .line 2
    .line 3
    const-class v1, Lx9/e;

    .line 4
    .line 5
    invoke-static {v0, v1}, Lt9/d;->a(Ljava/lang/Object;Ljava/lang/Class;)V

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Lw9/b$c;->b:Lx9/c;

    .line 9
    .line 10
    if-nez v0, :cond_0

    .line 11
    .line 12
    new-instance v0, Lx9/c;

    .line 13
    .line 14
    invoke-direct {v0}, Lx9/c;-><init>()V

    .line 15
    .line 16
    .line 17
    iput-object v0, p0, Lw9/b$c;->b:Lx9/c;

    .line 18
    .line 19
    :cond_0
    iget-object v0, p0, Lw9/b$c;->c:Lw9/f;

    .line 20
    .line 21
    const-class v1, Lw9/f;

    .line 22
    .line 23
    invoke-static {v0, v1}, Lt9/d;->a(Ljava/lang/Object;Ljava/lang/Class;)V

    .line 24
    .line 25
    .line 26
    new-instance v0, Lw9/b$b;

    .line 27
    .line 28
    iget-object v1, p0, Lw9/b$c;->a:Lx9/e;

    .line 29
    .line 30
    iget-object v2, p0, Lw9/b$c;->b:Lx9/c;

    .line 31
    .line 32
    iget-object v3, p0, Lw9/b$c;->c:Lw9/f;

    .line 33
    .line 34
    const/4 v4, 0x0

    .line 35
    invoke-direct {v0, v1, v2, v3, v4}, Lw9/b$b;-><init>(Lx9/e;Lx9/c;Lw9/f;Lw9/b$a;)V

    .line 36
    .line 37
    .line 38
    return-object v0
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
.end method

.method public b(Lx9/e;)Lw9/b$c;
    .locals 0

    .line 1
    invoke-static {p1}, Lt9/d;->b(Ljava/lang/Object;)Ljava/lang/Object;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    check-cast p1, Lx9/e;

    .line 6
    .line 7
    iput-object p1, p0, Lw9/b$c;->a:Lx9/e;

    .line 8
    .line 9
    return-object p0
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
.end method

.method public c(Lw9/f;)Lw9/b$c;
    .locals 0

    .line 1
    invoke-static {p1}, Lt9/d;->b(Ljava/lang/Object;)Ljava/lang/Object;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    check-cast p1, Lw9/f;

    .line 6
    .line 7
    iput-object p1, p0, Lw9/b$c;->c:Lw9/f;

    .line 8
    .line 9
    return-object p0
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
.end method
