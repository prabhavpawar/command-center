import React from "react";
import "react-step-progress-bar/styles.css";
import { ProgressBar, Step } from "react-step-progress-bar";

class Trend extends React.Component {
  render() {
    return (
      <ProgressBar percent={50}>
        <Step>
          {({ accomplished, index }) => (
            <div className={`indexedStep ${accomplished ? "accomplished" : ""}`}>
              {"  Payment Producer"}
            </div>
          )}
        </Step>
        <Step>
          {({ accomplished, index }) => (
            <div className={`indexedStep ${accomplished ? "accomplished" : ""}`}>
              {"  Payment Consumer"}
            </div>
          )}
        </Step>
        <Step>
          {({ accomplished, index }) => (
            <div className={`indexedStep ${accomplished ? "accomplished" : ""}`}>
              {"  Clearing Producer"}
            </div>
          )}
        </Step>
        <Step>
          {({ accomplished, index }) => (
            <div className={`indexedStep ${accomplished ? "accomplished" : ""}`}>
              {"  Clearing Consumer"}
            </div>
          )}
        </Step>
        <Step>
          {({ accomplished, index }) => (
            <div className={`indexedStep ${accomplished ? "accomplished" : ""}`}>
              {"  Fund Producer"}
            </div>
          )}
        </Step>
        <Step>
          {({ accomplished, index }) => (
            <div className={`indexedStep ${accomplished ? "accomplished" : ""}`}>
              {"  Fund Consumer"}
            </div>
          )}
        </Step>
      </ProgressBar>
    );
  }
}

export default Trend;
