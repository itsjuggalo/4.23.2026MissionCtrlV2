.class public final Lw9/c$b;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lw9/c;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "b"
.end annotation


# instance fields
.field public a:Lx9/q;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lw9/c$a;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lw9/c$b;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Lw9/e;
    .locals 3

    .line 1
    iget-object v0, p0, Lw9/c$b;->a:Lx9/q;

    .line 2
    .line 3
    const-class v1, Lx9/q;

    .line 4
    .line 5
    invoke-static {v0, v1}, Lt9/d;->a(Ljava/lang/Object;Ljava/lang/Class;)V

    .line 6
    .line 7
    .line 8
    new-instance v0, Lw9/c$c;

    .line 9
    .line 10
    iget-object v1, p0, Lw9/c$b;->a:Lx9/q;

    .line 11
    .line 12
    const/4 v2, 0x0

    .line 13
    invoke-direct {v0, v1, v2}, Lw9/c$c;-><init>(Lx9/q;Lw9/c$a;)V

    .line 14
    .line 15
    .line 16
    return-object v0
.end method

.method public b(Lx9/q;)Lw9/c$b;
    .locals 0

    .line 1
    invoke-static {p1}, Lt9/d;->b(Ljava/lang/Object;)Ljava/lang/Object;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    check-cast p1, Lx9/q;

    .line 6
    .line 7
    iput-object p1, p0, Lw9/c$b;->a:Lx9/q;

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
