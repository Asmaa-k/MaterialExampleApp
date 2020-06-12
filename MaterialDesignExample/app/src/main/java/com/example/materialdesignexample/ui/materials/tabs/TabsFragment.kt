package com.example.materialdesignexample.ui.materials.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.materialdesignexample.R
import com.google.android.material.tabs.TabLayout


class TabsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tabs, container, false)

        val tablayout = view.findViewById(R.id.tabs) as TabLayout
        // Creates and initializes an instance of BadgeDrawable associated with a tab.
        // Subsequent calls to this method will reuse the existing BadgeDrawable.
        // This method does not guarantee that the badge is visible.
        val badge1 = tablayout.getTabAt(1)?.orCreateBadge
        if (badge1 != null) {
            badge1.isVisible = true
            // Optionally show a number.
            badge1.number = 99
        }

        val badg2 = tablayout.getTabAt(2)?.orCreateBadge
        if (badg2 != null) {
            badg2.isVisible = true
            // Optionally show a number.
            badg2.number = 999
        }
        return view
    }
}