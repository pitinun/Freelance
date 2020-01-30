<template>
  <v-container style="background-color:#fbd800;">
    <div style="width: 100%;height: 50px;text-align: center;padding-top: 1%;min-height: 50px;background-color: goldenrod;color: currentColor;">
      <span style="
    position: absolute;
    top: 2.5%;
">
        พนักงาน
      </span>
    </div>
    
    
    
    <v-row
      style="
    padding: 10px;
    margin-left: 14%;
"
    >
      <v-row
        style="
    padding: 10px;
"
      >
        <v-col cols="5">
          <h4>1</h4>
          <v-select
            v-model="selectJobDescriptions"
            :items="jobDescriptions"
            item-value="id"
            item-text="description"
            label="select"
            @change="choseJobDescriptions"
            required
          >
          </v-select>
        </v-col>

        <v-row>
          <v-col cols="8">
            <h4>2</h4>
            <v-text-field
              labe="ชื่อพนักงาน"
              block
              disabled
              v-model="employeesName"
            >
            </v-text-field>
          </v-col>

          <v-col cols="5">
            <h4>3</h4>
            <v-select> </v-select>
          </v-col>
        </v-row>
      </v-row>
    </v-row>
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
      //alert(this.jobDescriptions[0].description)
    });
  }
};
</script>
<style>
.select-one {
  padding-left: 10px;
  padding-right: 10px;
}

.select-one::before {
  display: table;
  content: " ";
}

.select-one::after {
  clear: both;
}
</style>
