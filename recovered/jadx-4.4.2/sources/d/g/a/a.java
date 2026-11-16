package d.g.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, d.g.a.b.a {
    protected boolean b;
    protected boolean c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Cursor f804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Context f805e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f806f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected C0055a f807g;
    protected DataSetObserver h;
    protected d.g.a.b i;

    /* JADX INFO: renamed from: d.g.a.a$a, reason: collision with other inner class name */
    private class C0055a extends ContentObserver {
        C0055a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            a.this.i();
        }
    }

    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.b = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.b = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z) {
        f(context, cursor, z ? 1 : 2);
    }

    public abstract CharSequence a(Cursor cursor);

    @Override // d.g.a.b.a
    public Cursor b() {
        return this.f804d;
    }

    public void c(Cursor cursor) {
        Cursor cursorJ = j(cursor);
        if (cursorJ != null) {
            cursorJ.close();
        }
    }

    public abstract void e(View view, Context context, Cursor cursor);

    void f(Context context, Cursor cursor, int i) {
        b bVar;
        if ((i & 1) == 1) {
            i |= 2;
            this.c = true;
        } else {
            this.c = false;
        }
        boolean z = cursor != null;
        this.f804d = cursor;
        this.b = z;
        this.f805e = context;
        this.f806f = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f807g = new C0055a();
            bVar = new b();
        } else {
            bVar = null;
            this.f807g = null;
        }
        this.h = bVar;
        if (z) {
            C0055a c0055a = this.f807g;
            if (c0055a != null) {
                cursor.registerContentObserver(c0055a);
            }
            DataSetObserver dataSetObserver = this.h;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.b || (cursor = this.f804d) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.b) {
            return null;
        }
        this.f804d.moveToPosition(i);
        if (view == null) {
            view = g(this.f805e, this.f804d, viewGroup);
        }
        e(view, this.f805e, this.f804d);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.i == null) {
            this.i = new d.g.a.b(this);
        }
        return this.i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (!this.b || (cursor = this.f804d) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.f804d;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (this.b && (cursor = this.f804d) != null && cursor.moveToPosition(i)) {
            return this.f804d.getLong(this.f806f);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.b) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f804d.moveToPosition(i)) {
            if (view == null) {
                view = h(this.f805e, this.f804d, viewGroup);
            }
            e(view, this.f805e, this.f804d);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i);
    }

    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);

    protected void i() {
        Cursor cursor;
        if (!this.c || (cursor = this.f804d) == null || cursor.isClosed()) {
            return;
        }
        this.b = this.f804d.requery();
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.f804d;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0055a c0055a = this.f807g;
            if (c0055a != null) {
                cursor2.unregisterContentObserver(c0055a);
            }
            DataSetObserver dataSetObserver = this.h;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f804d = cursor;
        if (cursor != null) {
            C0055a c0055a2 = this.f807g;
            if (c0055a2 != null) {
                cursor.registerContentObserver(c0055a2);
            }
            DataSetObserver dataSetObserver2 = this.h;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f806f = cursor.getColumnIndexOrThrow("_id");
            this.b = true;
            notifyDataSetChanged();
        } else {
            this.f806f = -1;
            this.b = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
