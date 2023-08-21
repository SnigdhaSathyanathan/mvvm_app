package com.acabes.mvvmapp.model

//data class Characters(val JSON: List<HarryPotterCharacter>)
data class HarryPotterCharacter(val name: String,
                                val species: String,
                                val ancestry:String,
                                val house:String,
                                val hogwartsStudent:String,
                                val hogwartsStaff: String,
                                val wizard: Boolean,
                                val image: String)

