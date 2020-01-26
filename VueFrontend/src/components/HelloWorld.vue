<template>
  <v-container>
    <v-layout text-center wrap>
      <v-flex xs12>
        <v-img
          :src="require('../assets/logo.svg')"
          class="my-3"
          contain
          height="200"
        ></v-img>
      </v-flex>

      <v-flex>
        <h1 class="display-2 font-weight-bold mb-3">
          Welcome to Vuetify
        </h1>
      </v-flex>

      <v-row justify="center">
        <v-col cols="10">
          <v-select
            :items="jobDescriptions"
            v-model="selectJobDescriptions"
            label="ลักษณะงาน"
            item-text="description"
            item-value="id"
            @change="choseJobDescriptions"
            required
          >
          </v-select>
        </v-col>
      </v-row>

      <v-row justify="center">
        <v-col cols="10">
          <v-text-field
            labe="ชื่อพนักงาน"
            block
            disabled
            v-model="employeesName"
          ></v-text-field>
        </v-col>
      </v-row>
    </v-layout>
  </v-container>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      myfrom: {},
      jobDescriptions: [],
      employees: [],
      selectJobDescriptions: "",
      employeesName: ""
    };
  },
  methods: {
    choseJobDescriptions() {
      axios
        .get(
          `http://localhost:9000/api/emp/findByJobId/${this.selectJobDescriptions}`
        )
        .then(reponse => {
          this.employeesName = reponse.data[0].name;
        });
    }
  },

  mounted() {
    axios.get(`http://localhost:9000/api/jobs`).then(response => {
      this.jobDescriptions = response.data;
    });
  }
};
</script>
