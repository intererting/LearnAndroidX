package com.example.learnandroidx.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.learnandroidx.R
import kotlinx.android.synthetic.main.activity_expand_list.*
import kotlin.properties.Delegates

/**
 * @author    yiliyang
 * @date      21-1-26 上午9:03
 * @version   1.0
 * @since     1.0
 */
class ExpandableListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expand_list)
        listView.setAdapter(MyAdapter())
    }
}

class MyAdapter : BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return 4
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return when (groupPosition) {
            0 -> 1
            1 -> 3
            2 -> 5
            3 -> 7
            else -> 0
        }
    }

    override fun getGroup(groupPosition: Int): String {
        return "Group $groupPosition"
    }

    override fun getChild(groupPosition: Int, childPosition: Int): String {
        return "Child  $groupPosition  $childPosition"
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return (groupPosition * 100 + childPosition).toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup): View {
        val myViewHolder: MyViewHolder
        val groupView: View
        if (convertView == null) {
            groupView = LayoutInflater.from(parent.context).inflate(R.layout.item_expand_group, parent, false)
            myViewHolder = MyViewHolder().apply {
                textView = groupView.findViewById(R.id.text)
            }
            groupView.tag = myViewHolder
        } else {
            groupView = convertView
            myViewHolder = convertView.tag as MyViewHolder
        }
        myViewHolder.textView.text = getGroup(groupPosition)
        return groupView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val myViewHolder: MyViewHolder
        val childView: View
        if (convertView == null) {
            childView = LayoutInflater.from(parent.context).inflate(R.layout.item_expand_list, parent, false)
            myViewHolder = MyViewHolder().apply {
                textView = childView.findViewById(R.id.text)
            }
            childView.tag = myViewHolder
        } else {
            childView = convertView
            myViewHolder = convertView.tag as MyViewHolder
        }
        myViewHolder.textView.text = getChild(groupPosition, childPosition)
        return childView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    class MyViewHolder {
        var textView: TextView by Delegates.notNull()
    }

}