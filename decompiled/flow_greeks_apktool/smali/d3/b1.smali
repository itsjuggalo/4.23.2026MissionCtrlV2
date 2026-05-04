.class public final synthetic Ld3/b1;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ls0/a;


# instance fields
.field public final synthetic a:Ld3/j;

.field public final synthetic b:Ld3/i;


# direct methods
.method public synthetic constructor <init>(Ld3/j;Ld3/i;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Ld3/b1;->a:Ld3/j;

    .line 5
    .line 6
    iput-object p2, p0, Ld3/b1;->b:Ld3/i;

    .line 7
    .line 8
    return-void
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
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
.end method


# virtual methods
.method public final accept(Ljava/lang/Object;)V
    .locals 2

    .line 1
    iget-object v0, p0, Ld3/b1;->a:Ld3/j;

    .line 2
    .line 3
    iget-object v1, p0, Ld3/b1;->b:Ld3/i;

    .line 4
    .line 5
    check-cast p1, Lcom/android/billingclient/api/a;

    .line 6
    .line 7
    invoke-virtual {v1}, Ld3/i;->a()Ljava/lang/String;

    .line 8
    .line 9
    .line 10
    move-result-object v1

    .line 11
    invoke-interface {v0, p1, v1}, Ld3/j;->a(Lcom/android/billingclient/api/a;Ljava/lang/String;)V

    .line 12
    .line 13
    .line 14
    return-void
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
