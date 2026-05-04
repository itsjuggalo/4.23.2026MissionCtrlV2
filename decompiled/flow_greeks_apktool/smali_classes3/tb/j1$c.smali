.class public final Ltb/j1$c;
.super Lrb/g0;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltb/j1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "c"
.end annotation


# instance fields
.field public final b:Ltb/j1;


# direct methods
.method public constructor <init>(Ltb/j1;)V
    .locals 0

    .line 2
    invoke-direct {p0}, Lrb/g0;-><init>()V

    .line 3
    iput-object p1, p0, Ltb/j1$c;->b:Ltb/j1;

    return-void
.end method

.method public synthetic constructor <init>(Ltb/j1;Ltb/j1$a;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Ltb/j1$c;-><init>(Ltb/j1;)V

    return-void
.end method


# virtual methods
.method public a(Lrb/r0$g;)Lrb/g0$b;
    .locals 1

    .line 1
    invoke-static {}, Lrb/g0$b;->d()Lrb/g0$b$a;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    iget-object v0, p0, Ltb/j1$c;->b:Ltb/j1;

    .line 6
    .line 7
    invoke-virtual {p1, v0}, Lrb/g0$b$a;->b(Ljava/lang/Object;)Lrb/g0$b$a;

    .line 8
    .line 9
    .line 10
    move-result-object p1

    .line 11
    invoke-virtual {p1}, Lrb/g0$b$a;->a()Lrb/g0$b;

    .line 12
    .line 13
    .line 14
    move-result-object p1

    .line 15
    return-object p1
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
