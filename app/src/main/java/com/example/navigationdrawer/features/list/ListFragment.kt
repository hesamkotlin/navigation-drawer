package com.example.navigationdrawer.features.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navigationdrawer.R
import com.example.navigationdrawer.databinding.FragmentListBinding
import com.example.navigationdrawer.features.InterActionViewModel


class ListFragment : Fragment() {

    private val adapter = PokemonListAdapter()

    private lateinit var mBinding: FragmentListBinding

    private val interActionViewModel by activityViewModels<InterActionViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentListBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initValues()
        observe()
    }

    private fun observe(){
        interActionViewModel.onViewTypeChanged.observe(viewLifecycleOwner, Observer { isLinear ->
           if (isLinear){
               mBinding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
               adapter.setItemViewType(R.layout.item_linear_card)
           }else{
               mBinding.recyclerView.layoutManager = GridLayoutManager(requireContext() , 2)
               adapter.setItemViewType(R.layout.item_grid_card)
           }
        })
    }

    private fun initViews() {
        mBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@ListFragment.adapter
        }
    }

    private fun initValues() {
        val items = mutableListOf(
            Pokemon(
                1,
                R.drawable.pokemon,
                "Celebi & Venusaur-GX",
                " Pokémon - Basic, TAG TEAM, GX"
            ),
            Pokemon(
                2,
                R.drawable.pokemon,
                "Celebi & Venusaur-GX",
                " Pokémon - Basic, TAG TEAM, GX"
            ),
            Pokemon(
                3,
                R.drawable.pokemon,
                "Celebi & Venusaur-GX",
                " Pokémon - Basic, TAG TEAM, GX"
            ),
            Pokemon(
                4,
                R.drawable.pokemon,
                "Celebi & Venusaur-GX",
                " Pokémon - Basic, TAG TEAM, GX"
            ),
            Pokemon(
                5,
                R.drawable.pokemon,
                "Celebi & Venusaur-GX",
                " Pokémon - Basic, TAG TEAM, GX"
            ),
            Pokemon(
                6,
                R.drawable.pokemon,
                "Celebi & Venusaur-GX",
                " Pokémon - Basic, TAG TEAM, GX"
            ),
            Pokemon(
                7,
                R.drawable.pokemon,
                "Celebi & Venusaur-GX",
                " Pokémon - Basic, TAG TEAM, GX"
            ),
            Pokemon(
                8,
                R.drawable.pokemon,
                "Celebi & Venusaur-GX",
                " Pokémon - Basic, TAG TEAM, GX"
            ),
            Pokemon(
                9,
                R.drawable.pokemon,
                "Celebi & Venusaur-GX",
                " Pokémon - Basic, TAG TEAM, GX"
            ),
            Pokemon(
                10,
                R.drawable.pokemon,
                "Celebi & Venusaur-GX",
                " Pokémon - Basic, TAG TEAM, GX"
            ),
            Pokemon(
                11,
                R.drawable.pokemon,
                "Celebi & Venusaur-GX",
                " Pokémon - Basic, TAG TEAM, GX"
            ),
            Pokemon(
                12,
                R.drawable.pokemon,
                "Celebi & Venusaur-GX",
                " Pokémon - Basic, TAG TEAM, GX"
            ),
            Pokemon(
                13,
                R.drawable.pokemon,
                "Celebi & Venusaur-GX",
                " Pokémon - Basic, TAG TEAM, GX"
            ),
            Pokemon(
                14,
                R.drawable.pokemon,
                "Celebi & Venusaur-GX",
                " Pokémon - Basic, TAG TEAM, GX"
            ),
            Pokemon(
                15,
                R.drawable.pokemon,
                "Celebi & Venusaur-GX",
                " Pokémon - Basic, TAG TEAM, GX"
            ),

            )
        adapter.submitList(items)
    }


}